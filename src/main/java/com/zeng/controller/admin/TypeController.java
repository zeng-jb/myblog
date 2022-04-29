package com.zeng.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zeng.pojo.Type;
import com.zeng.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin")
@Transactional
public class TypeController {

    @Autowired
    private TypeService typeService;

    //分页查询分类列表
    @GetMapping("/types")
    public String list(Model model,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        //按id字段降序，用到了PageHelper插件
        String orderby = "id desc";
        PageHelper.startPage(pageNum,10,orderby);
        List<Type> list = typeService.getAllType();
        PageInfo<Type> pageInfo = new PageInfo<>(list);
        model.addAttribute("pageInfo",pageInfo);
        return "admin/types";
    }

    //返回新增分类界面
    @GetMapping("/types/input")
    public String input(Model model){
        model.addAttribute("type",new Type());
        return "admin/types-input";
    }

    //新增分类
    @PostMapping("/types")
    @Transactional
    public String post( Type type, RedirectAttributes attributes){
        Type type1 = typeService.getTypeByName(type.getName());
        if (type1 != null){
            attributes.addFlashAttribute("message","不能重复添加分类");
            return "redirect:/admin/types/input";
        }
        int t = typeService.saveType(type);
        if(t != 0){
            attributes.addFlashAttribute("message","添加成功");
        }else{
            attributes.addFlashAttribute("message","添加失败");
        }
        return "redirect:/admin/types";
    }

    //跳转到修改分类的界面
    @GetMapping("/types/{id}/input")
    public String editInput(Model model,@PathVariable Long id){
        model.addAttribute("type",typeService.getType(id));
        return "admin/types-input";
    }

    //编辑修改分类
    @PostMapping("/types/{id}")
    public String editPost( Type type,RedirectAttributes attributes){
        Type type1 = typeService.getTypeByName(type.getName());
        if(type1 != null){
            attributes.addFlashAttribute("message","不能重复添加分类");
            return "redirect:/admin/types/{id}/input";
        }
        int t = typeService.updateType(type);
        if(t == 0){
            attributes.addFlashAttribute("message","更新失败");
        }else{
            attributes.addFlashAttribute("message","更新成功");
        }
        return "redirect:/admin/types";
    }

    //删除分类
    @GetMapping("/types/{id}/delete")
    public String deleteType(@PathVariable Long id,RedirectAttributes attributes){
        typeService.deleteType(id);
        attributes.addFlashAttribute("message","删除成功");
        return "redirect:/admin/types";
    }
}
