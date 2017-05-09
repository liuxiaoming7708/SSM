package com.liu.ssm.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liu.ssm.dao.UserMapper;
import com.liu.ssm.model.User;
import com.liu.ssm.model.UserExample;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.liu.ssm.service.UserService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("/showUser")
    public String toIndex(HttpServletRequest request,Model model){
        int userId = Integer.parseInt(request.getParameter("id"));
        User user = this.userService.getUserById(userId);
        model.addAttribute("user", user);
        return "showUser";
    }
    @RequestMapping("/showFTL")
    public String showftl(Model model){
        String word0 = "Helloliuxiaoming ";
        String word1 = "WorldFTL!";
        //將數據添加到視圖數據容器中
        model.addAttribute("word0",word0);
        model.addAttribute("word1",word1);
        return "helloWorld.ftl";
    }
    /**
     * 获取所有用户列表
     * @param request
     * @return
     */
    @RequestMapping("/getAllUser")
    public String getAllUser(HttpServletRequest request,
                             @RequestParam(defaultValue = "1") Integer currentPage,
                             @RequestParam(defaultValue = "3") Integer limit,
                             Model model){
        //request.setAttribute("userList", user);
        UserExample userExample = new UserExample();
        UserExample.Criteria c= userExample.createCriteria();
        PageHelper.startPage(currentPage, limit); // 核心分页代码
        Page<User> user = (Page<User>)userService.findAll(userExample);
        System.out.println(userService.findAll(userExample));
       // Page<User> user = (Page<User>)userMapper.selectByExample(userExample);

        PageInfo pageInfo = new PageInfo(user);
        long total = pageInfo.getTotal();
        System.out.println("total:"+total);
        int pages = pageInfo.getPages();
        System.out.println("pages:"+pages);
        int pageSize = pageInfo.getPageSize();
        System.out.println(pageSize);
        //==========================================
        model.addAttribute("pages", user.getPages());
        model.addAttribute("total", user.getTotal());
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("limit", limit);
        model.addAttribute("userList", user);
        return "/allUser.ftl";
        }
    /**
     * 跳转到添加用户界面
     * @param
     * @return
     */
     @RequestMapping("/toAddUser")
     public String toAddUser(){
      return "/addUser.ftl";
   }
   /**
     * 添加用户并重定向
     * @param user
     * @param
     * @return
     */
    @RequestMapping("/addUser")
    public String addUser(User user,Model model){
        System.out.println(user.getUserName());

        userService.save(user);
        return "redirect:/user/getAllUser";
        }
   /**
     56.     *编辑用户
     57.     * @param user
     58.     * @param request
     59.     * @return
     60.     */
    @RequestMapping("/updateUser")
    public String updateUser(User user,HttpServletRequest request,Model model){
        System.out.println(user.getUserName());
        if(userService.update(user)){
            user = userService.findById(user.getId());
           // request.setAttribute("user", user);
            model.addAttribute("user", user);
             return "redirect:/user/getAllUser";
            }else{
            return "/error";
            }
      }
   /**
     73.     * 根据id查询单个用户
     74.     * @param id
     75.     * @param request
     76.     * @return
     77.     */
            @RequestMapping("/getUser")
    public String getUser(int id,HttpServletRequest request,Model model){
              // request.setAttribute("user", userService.findById(id));
               model.addAttribute("user", userService.getUserById(id));
              return "/editUser.ftl";
           }
    /**
     85.     * 删除用户
     86.     * @param id
     87.     * @param request
     88.     * @param response
     89.     */
               @RequestMapping("/delUser")
                   public @ResponseBody
               String delUser(@RequestParam String id){
                       JSONObject J=new JSONObject();
                   System.out.println(id);
                       if(userService.delete(Integer.parseInt(id))){
                           J.put("boolean", true);
                       }else{
                           J.put("boolean", false);
                       }
                       return J.toString();
         }






}