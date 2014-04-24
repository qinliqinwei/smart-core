package com.incito.product.web;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.incito.product.common.BaseCtrl;

/**
 * web 首页 业务处理
 * @author zhaigt
 *
 */
@Controller
@RequestMapping("/")
public class IndexCtrl extends BaseCtrl{
  
  /**
   * web端 首页 数据处理
   * 接收web首页 根路径的请求，以及/index 的请求 
   * 改访问绑定两个路径 便于访问 和程序跳转处理
   */
  @RequestMapping(value = {"","/index"})
  public ModelAndView index(){
    ModelAndView mv = new ModelAndView("index");// 同步跳转
    try {
      mv.addObject("msg", "hello");// 绑定变量
    } catch (Exception e) {
      e.printStackTrace();
    }
    return mv;
  }
      
  /**
   * 用户退出登录
   */
  @RequestMapping("/quit")
  public ModelAndView quit(HttpServletResponse response){
    ModelAndView mv = new ModelAndView("redirect:/index");
    session.removeAttribute(WEB_SESSION_USER);
    session.invalidate();
    return mv;
  }
  
}