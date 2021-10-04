package com.msb.donbao.common.base.result;

import com.msb.donbao.common.base.enums.StateCodeEnum;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class ResultWrapper<T>  implements Serializable {
/**
 @Builder 内部做了什么
 创建一个名为 ThisClassBuilder 的内部静态类，并具有和实体类相同的属性（称为构建器）
 在构建器中：对于目标类中的所有的属性和未初始化的 final 字段，都会在构建器中创建对应属性
 在构建器中：创建一个无参的 default 构造函数
 在构建器中：实体类中的每个参数，都会对应创建类似于 setter 的方法，方法名与该参数名相同。 并且返回值是构建器本身（便于链式调用）
 在构建器中：会创建一个 build 方法，调用 build 方法，就会根据设置的值进行创建实体对象
 在构建器中：会生成一个 toString 方法
 在实体类中：会创建一个 builder 方法，它的目的是用来创建构建器
 在业务层如果有多个参数需要重新包装VO的话，用@Builder注解可以避免写大量的Set代码 让业务层看起来干净整洁
 优点：
 不需些太多的set方法来定义属性内容
 写法更优雅
 缺点：
 在生成对象实例之前，实际上是先创建了一个Builder实例,这样很明显额外占用了内存

 */

//状态码
 private int code;

 //提示信息
 private String msg;

 private T date;

 /*
 * 返回成功的包装
 * */

 public static ResultWrapper.ResultWrapperBuilder getSuccessBuilder(){
  return ResultWrapper.builder().code(StateCodeEnum.SUCCESS.getCode()).msg(StateCodeEnum.SUCCESS.getMsg());
 }

 public static ResultWrapper.ResultWrapperBuilder getFailBuilder(){
  return ResultWrapper.builder().code(StateCodeEnum.FAIL.getCode()).msg(StateCodeEnum.FAIL.getMsg());
 }


}
