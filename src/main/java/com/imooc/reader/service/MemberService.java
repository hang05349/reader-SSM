package com.imooc.reader.service;

import com.imooc.reader.entity.Evaluation;
import com.imooc.reader.entity.Member;
import com.imooc.reader.entity.MemberReadState;

/**
 * @author : [xieHang]
 * @version : [v1.0.0]
 * @date : [2021/11/23 16:41]
 * Description   : []
 */
public interface MemberService {
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
    public Member createMember(String username, String password, String nickname);

    /**
     * Description:登录校验
     *
     * @param username 用户名
     * @param password 用户密码
     * @return Member
     * @author [xieHang]
     * @date [2021/11/23 22:08]
     */
    public Member checkLogin(String username, String password);

    /**
     * Description:；获取当前账号的阅读状态
     *
     * @param memberId 登录账号id
     * @param bookId 图书编号
     * @return MemberReadState 阅读状态对象
     * @author [xieHang]
     * @date [2021/11/24 9:52]
     */
    public MemberReadState selectMemberReadState(Long memberId, Long bookId);
    /**
     *Description: 更新阅读状态
     *@author [xieHang]
     *@date [2021/11/24 10:48]
     * @param memberId 会员编号
     * @param bookId 图书编号
     * @param readState 阅读状态
     * @return MemberReadState
     */
    public MemberReadState updateMemberReadState(Long memberId,Long bookId,Integer readState);
    /**
     *Description:
     *@author [xieHang]
     *@date [2021/11/24 15:15]
     * @param memberId 会员编号
     * @param bookId 图书id
     * @param score 评分
     * @param content 短评
     * @return Evaluation 短评对象
     */
    public Evaluation evaluate(Long memberId,Long bookId,Integer score,String content);

    /**
     *Description: 短评点赞
     *@author [xieHang]
     *@date [2021/11/24 15:44]
     * @param evaluationId 短评编号
     * @return Evaluation 短评对象
     */
    public Evaluation enjoy(Long evaluationId);
}
