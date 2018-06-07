package com.example.travelms.entity;

import java.io.Serializable;

/**
 * 会员管理
 */
public class User implements Serializable {
 private static final long serialVersionUID = 1L;

 //用户ID
 private Integer userId;
 //用户姓名
  private String userName;
  //用户电话
   private String phone;
   //用户邮箱
   private String email;
   //用户积分
   private Integer scores;
   //验证码
   private String code;

 public Integer getUserId() {
  return userId;
 }

 public void setUserId(Integer userId) {
  this.userId = userId;
 }

 public String getUserName() {
  return userName;
 }

 public void setUserName(String userName) {
  this.userName = userName;
 }

 public String getPhone() {
  return phone;
 }

 public void setPhone(String phone) {
  this.phone = phone;
 }

 public String getEmail() {
  return email;
 }

 public void setEmail(String email) {
  this.email = email;
 }

 public Integer getScores() {
  return scores;
 }

 public void setScores(Integer scores) {
  this.scores = scores;
 }

 public String getCode() {
  return code;
 }

 public void setCode(String code) {
  this.code = code;
 }
}
