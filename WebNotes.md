<h1 id="z6s4Y">1.JavaScript简介</h1>
<h1 id="FtqhP">2.JavaScript基础语法</h1>
<h2 id="BDUuI">1.导入方式</h2>
```html
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <!-- <script>标签导入js脚本 -->
    <script src="./index.js"></script>

  </head>
  <body>

  </body>
</html>
```

<h2 id="kpdzU">2.基础语法</h2>
<h3 id="vehCm">1.输出语句</h3>
```javascript
// 输出至警告框
window.alert()

// 输出至HTML
document.write()

// 输出至浏览器控制台
console.log()
```

<h3 id="ZaX9W">2.变量</h3>
![](https://cdn.nlark.com/yuque/0/2024/png/40678113/1728474259919-7a8dd6bf-8d09-400f-ba0a-f83da3fb9f1f.png)

<h3 id="IvxyL">3.函数</h3>
![](https://cdn.nlark.com/yuque/0/2024/png/40678113/1728474708021-0340925d-bb03-4a94-87c9-df198f6780e5.png)

![](https://cdn.nlark.com/yuque/0/2024/png/40678113/1728561260441-7ac36c96-68d7-4e92-a385-100c4db90d49.png)

<h2 id="wmTyU">3.面向对象</h2>
<h3 id="gUKdK">1.Array</h3>
<h4 id="gh24g">1.数组的定义</h4>
![](https://cdn.nlark.com/yuque/0/2024/png/40678113/1728565432812-389c68c3-3f65-4448-af7f-5c46884ee6ed.png)

<h4 id="jC9bC">2.数组的特点</h4>
类型可变，长度可变

```javascript
var arr = [1, 2.2, "3", true];
arr[10] = 10;
console.log(arr);


// 控制台输出
[
    1,
    2.2,
    "3",
    true,
    null,
    null,
    null,
    null,
    null,
    null,
    10
]
```

<h4 id="tlNk2">3.数组的常用属性与方法</h4>
```javascript
// 返回或设置数组中元素的数量
length


// 遍历数组中的每个有值的元素，并每次调用传入的参数
forEach()
// 两种遍历方式
arr.forEach(function(e) {
    console.log(e);
})

console.log("================")

arr.forEach((e) => {
    console.log(e);
})


// 追加新元素
push()
// 将新元素添加到数组队尾
arr.push(7, 8, 9);


// 删除元素
splice()
// 从索引2开始删除3个元素
arr.splice(2, 3);
```

<h3 id="qYL4l">2.String</h3>
<h4 id="CGYz5">1.String的定义</h4>
![](https://cdn.nlark.com/yuque/0/2024/png/40678113/1728567207875-0b02ecc9-8b61-43e3-abaa-74589b112805.png)

<h4 id="USLmx">2.String的常用属性</h4>
```javascript
// 返回字符串的长度
length


// 返回指定索引位置的字符
charAT()


// 检索子串在主串中的位置
indexOf()


// 去除字符串两侧的空格
trim()


// 通过索引提取子串
substring()
```

<h3 id="gDAUF">3.自定义对象</h3>
![](https://cdn.nlark.com/yuque/0/2024/png/40678113/1728718053070-2b6ee56e-b361-4bd4-bfe2-ba5866360001.png)

```javascript
// 定义对象
var user = {
    // 定义属性
    name: "Tom",
    age: 18,
    gender: "male",

    // 定义方法
    eat() {
        alert("Eat.");
    }
}


// 调用对象的属性和方法
console.log(user.name);
user.eat();
```

<h3 id="Dy91r">4.JSON</h3>
![](https://cdn.nlark.com/yuque/0/2024/png/40678113/1728718729268-77a36b3b-e319-43e9-9282-d8b915331ed3.png)

```javascript
// 定义JSON
var jsonStr = '{"name":"Tom", "age":18, "addr":["BeiJing", "ShangHai", "TaiYuan"]}';


// JSON转JS对象
JSON.parse()
// 将上面JSON转化JS对象
var JSobject = JSON.parse(jsonStr);
alert(JSobject.name);


// JS对象转JSON
JSON.stringify()
// 将转化后的对象再转化为JSON
var jsonStr_2 = JSON.stringify(JSobject);
alert(jsonStr_2);
```

<h3 id="wq35U">5.BOM</h3>
![](https://cdn.nlark.com/yuque/0/2024/png/40678113/1728720446258-af6566ef-9e6f-49f1-894c-6e2247c087f0.png)

<h3 id="IYFA8">6.DOM</h3>
![](https://cdn.nlark.com/yuque/0/2024/png/40678113/1728723349751-29b65437-3f84-4de8-bd58-aa857e878fcd.png)

<h4 id="N9iFS">DOM的获取</h4>
Document对象中提供了以下获取Element元素对象的函数:

1.根据id属性值获取,返回单个Element对象

```javascript
var h1 = document.getElementById("h1");
```

2.根据标签名称获取,返回Element对象数组

```javascript
var divs = document.getElementsByTagName("div");
```

3.根据name属性值获取,返回Element对象数组

```javascript
var hobbys = document.getElementsByName("hobby");
```

4.根据name属性值获取,返回Element对象数组

```javascript
var class = document.getElementsByClassName("clas");
```

<h3 id="ShiD1">7.事件</h3>
<h1 id="uGJHI">3.Vue基础</h1>
安装Node.js

Node.js官网：[https://cn.vuejs.org/](https://cn.vuejs.org/)

[Vue安装与配置教程（非常详细）从零基础入门到精通，看完这一篇就够了-CSDN博客](https://blog.csdn.net/Javachichi/article/details/132868889?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522ED0E68C9-6128-4E72-960E-6FE6D39DF0BA%2522%252C%2522scm%2522%253A%252220140713.130102334..%2522%257D&request_id=ED0E68C9-6128-4E72-960E-6FE6D39DF0BA&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~top_positive~default-1-132868889-null-null.142^v100^pc_search_result_base6&utm_term=%E5%AE%89%E8%A3%85vue&spm=1018.2226.3001.4187)

<h1 id="EKocU">4.Maven</h1>
<h2 id="FbvoX">1.Maven简单介绍</h2>
Maven官网：[https://maven.apache.org/](https://maven.apache.org/)

![](https://cdn.nlark.com/yuque/0/2024/png/40678113/1728906085988-96d8694f-1f5c-4992-9491-3046f7e03450.png)

Maven的模型：

![](https://cdn.nlark.com/yuque/0/2024/png/40678113/1728906200131-ba168a13-c8de-4b9b-a271-771219152e6f.png)

Maven的仓库相关：![](https://cdn.nlark.com/yuque/0/2024/png/40678113/1728906401897-6fe1ce47-9301-4c3a-aa36-d9956c981380.png)

Maven的作用：

![](https://cdn.nlark.com/yuque/0/2024/png/40678113/1728904982889-20a06bb7-fadf-41f7-bfc3-90db6c0e1384.png)

<h2 id="xbaPz">2.安装与配置Maven</h2>
<h3 id="BBnZb">1.安装</h3>
解压即可![](https://cdn.nlark.com/yuque/0/2024/png/40678113/1728916313585-a48dd505-5807-4bce-8bda-f13267153551.png)

<h3 id="RuQSU">2.配置本地仓库</h3>
配置文件路径

```javascript
./conf/settings.xml
```











