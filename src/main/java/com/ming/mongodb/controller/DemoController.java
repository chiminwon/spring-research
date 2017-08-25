package com.ming.mongodb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ming.mongodb.dao.DemoInfoRepository;
import com.ming.mongodb.pojo.DemoInfo;

@RestController
public class DemoController {
  
   @Autowired
   private DemoInfoRepository demoInfoRepository;
   
   @Autowired
   private MongoTemplate mongoTemplate;
  
   @RequestMapping("save")
   public String save(){
      DemoInfo demoInfo = new DemoInfo();
      demoInfo.setName("张三");
      demoInfo.setAge(20);
      demoInfoRepository.save(demoInfo);
     
      demoInfo = new DemoInfo();
      demoInfo.setName("李四");
      demoInfo.setAge(30);
      demoInfoRepository.save(demoInfo);
     
      return "ok";
   }
  
   @RequestMapping("find")
   public List<DemoInfo> find(){
      return demoInfoRepository.findAll();
   }
  
   @RequestMapping("findByName")
   public DemoInfo findByName(){
      return demoInfoRepository.findByName("张三");
   }
   
   @RequestMapping("find2")
   public List<DemoInfo> find2(){
      return mongoTemplate.findAll(DemoInfo.class);
   }
  
}