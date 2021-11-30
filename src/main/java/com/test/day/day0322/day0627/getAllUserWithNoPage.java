//package com.test.day0627;
//
//import java.util.List;
//
///**
// * @Package: com.test.day0627
// * @ClassName: getAllUserWithNoPage
// * @Author: 86150
// * @Description: 11
// * @Date: 2020/6/28 11:10
// */
//public class getAllUserWithNoPage {
//
//    public List<UsersDO> getAllUserWithNoPage(){
//
//
//        try{
//
//            //序列化器，将key的值设置为字符串
//            RedisSerializer redisSerializer=new StringRedisSerializer();
//            redisTemplate.setKeySerializer(redisSerializer);
//
//            //查缓存
//            List<UsersDO> list=(List<UsersDO>)redisTemplate.opsForValue().get("allUsers");
//
//            if(null==list){
//                //双重检测 锁
//                synchronized (this) {
//
//                    List<UsersDO> list1 = (List<UsersDO>) redisTemplate.opsForValue().get("allUsers");
//                    if (null == list1) {
//
//                        UsersQuery query=new UsersQuery();
//                        list=usersDOMapper.selectByExample(query);
//                        redisTemplate.opsForValue().set("allUsers", list);
//
//                        System.out.println("从数据库中取数据");
//                    }
//                    else{
//                        System.out.println("从缓存中取数据");
//                    }
//                }
//            }
//            else{
//                System.out.println("从缓存中取数据");
//            }
//            return list;
//        }
//        catch (Exception e) {
//            logger.error("UserService.getAllUserWithNoPage error",e);
//        }
//        return null;
//    }
//}
