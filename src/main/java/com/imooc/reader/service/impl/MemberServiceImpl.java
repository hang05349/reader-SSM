package com.imooc.reader.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.imooc.reader.entity.Evaluation;
import com.imooc.reader.entity.Member;
import com.imooc.reader.entity.MemberReadState;
import com.imooc.reader.mapper.EvaluationMapper;
import com.imooc.reader.mapper.MemberMapper;
import com.imooc.reader.mapper.MemberReadStateMapper;
import com.imooc.reader.service.MemberService;
import com.imooc.reader.service.exception.BussinessException;
import com.imooc.reader.utils.MD5Utils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @author : [xieHang]
 * @version : [v1.0.0]
 * @date : [2021/11/23 16:48]
 * Description   : []
 */
@Service("memberService")
@Transactional
public class MemberServiceImpl implements MemberService {
    @Resource
    private MemberMapper memberMapper;
    @Resource
    private MemberReadStateMapper memberReadStateMapper;
    @Resource
    private EvaluationMapper evaluationMapper;
    /**
     * Description: 会员注册
     *
     * @param username 用户名
     * @param password 密码
     * @param nickname 昵称
     * @return Member 新会员对象
     * @author [xieHang]
     * @date [2021/11/23 16:48]
     */
    public Member createMember(String username, String password, String nickname) {
        QueryWrapper<Member> queryWrapper = new QueryWrapper<Member>();
        queryWrapper.eq("username",username);
        List<Member> memberList = memberMapper.selectList(queryWrapper);
        //判断用户名是否已存在
        if(memberList.size() > 0){
          throw new BussinessException("M01","用户名已存在");
        }
        Member member = new Member();
        member.setUsername(username);
        member.setNickname(nickname);
        //盐值
        int salt = new Random().nextInt(1000)+1000;
        String md5 = MD5Utils.md5Digest(password,salt);
        member.setPassword(md5);
        member.setSalt(salt);
        member.setCreateTime(new Date());
        memberMapper.insert(member);
        return member;
    }

    /**
     * Description:登录校验
     *
     * @param username 用户名
     * @param password 用户密码
     * @return Member
     * @author [xieHang]
     * @date [2021/11/23 22:08]
     */
    public Member checkLogin(String username, String password) {
        QueryWrapper<Member> queryWrapper = new QueryWrapper<Member>();
        queryWrapper.eq("username",username);
        Member member = memberMapper.selectOne(queryWrapper);
        if(member == null){
            throw new BussinessException("M02","用户不存在");
        }
        String md5 = MD5Utils.md5Digest(password,member.getSalt());
        if(!md5.equals(member.getPassword())){
            throw new BussinessException("M03","账号或密码输入错误");
        }
        return member;
    }

    /**
     * Description:；获取当前账号的阅读状态
     *
     * @param memberId 登录账号id
     * @param bookId   图书编号
     * @return MemberReadState 阅读状态对象
     * @author [xieHang]
     * @date [2021/11/24 9:52]
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
    public MemberReadState selectMemberReadState(Long memberId, Long bookId) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("book_id",bookId);
        queryWrapper.eq("member_id",memberId);
        MemberReadState memberReadState = memberReadStateMapper.selectOne(queryWrapper);
        return memberReadState;
    }

    /**
     * Description: 更新阅读状态
     *
     * @param memberId  会员编号
     * @param bookId    图书编号
     * @param readState 阅读状态对象
     * @return MemberReadState
     * @author [xieHang]
     * @date [2021/11/24 10:48]
     */
    public MemberReadState updateMemberReadState(Long memberId, Long bookId, Integer readState) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("book_id",bookId);
        queryWrapper.eq("member_id",memberId);
        MemberReadState memberReadState = memberReadStateMapper.selectOne(queryWrapper);
        //有数据则更新，无数据则新建
        if(memberReadState ==null){
            memberReadState = new MemberReadState();
            memberReadState.setReadState(readState);
            memberReadState.setMemberId(memberId);
            memberReadState.setBookId(bookId);
            memberReadState.setCreateTime(new Date());
            memberReadStateMapper.insert(memberReadState);
        }else {
            memberReadState.setReadState(readState);
            memberReadStateMapper.updateById(memberReadState);
        }
        return memberReadState;
    }

    /**
     * Description:
     *
     * @param memberId 会员编号
     * @param bookId   图书id
     * @param score    评分
     * @param content  短评
     * @return Evaluation 短评对象
     * @author [xieHang]
     * @date [2021/11/24 15:15]
     */
    public Evaluation evaluate(Long memberId, Long bookId, Integer score, String content) {
        Evaluation evaluation = new Evaluation();
        evaluation.setMemberId(memberId);
        evaluation.setBookId(bookId);
        evaluation.setScore(score);
        evaluation.setContent(content);
        evaluation.setCreateTime(new Date());
        evaluation.setState("enable");
        evaluation.setEnjoy(0);
        evaluationMapper.insert(evaluation);
        return evaluation;
    }

    /**
     * Description: 短评点赞
     *
     * @param evaluationId 短评编号
     * @return Evaluation 短评对象
     * @author [xieHang]
     * @date [2021/11/24 15:44]
     */
    public Evaluation enjoy(Long evaluationId) {
        Evaluation evaluation = evaluationMapper.selectById(evaluationId);
        evaluation.setEnjoy(evaluation.getEnjoy()+1);
        evaluationMapper.updateById(evaluation);
        return evaluation;
    }

}
