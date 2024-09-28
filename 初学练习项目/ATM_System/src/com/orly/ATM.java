package com.orly;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class ATM {
    private ArrayList<Account> accounts = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    // 首页
    public void start() {
        outerLoop:while (true) {
            System.out.println("===欢迎您进入到ATM系统===");
            System.out.println("1.用户登录");
            System.out.println("2.用户开户");
            System.out.println("0.退出系统");
            System.out.println("请选择：");
            int code = sc.nextInt();

            switch (code) {
                case 1:
                    break;
                case 2:
                    creatAccount();
                case 0:
                    break outerLoop;
                default:
                    System.out.println("ERROR！！！");
            }
            System.out.println();
        }
    }


    // 添加账户
    private void creatAccount() {
        // 创建一个用户对象，封装用户的开户信息
        Account acc = new Account();

        // 输入开户信息
        System.out.println("请输入您的账户名称：");
        String name = sc.next();
        acc.setUserName(name);

        // 输入并处理性别
        System.out.println("请输入您的性别：");

        // 输入并处理密码
        while (true) {
            System.out.println("请输入您的账户密码：");
            String passWord = sc.next();
            System.out.println("请再次输入您的账户密码：");
            String passWord_OK = sc.next();
            if (passWord.equals(passWord_OK)) {
                acc.setPassWord(passWord);
                break;
            }else {
                System.out.println("密码不一致，请重新输入！");
            }
        }

        // 输入提现额度
        System.out.println("请输入您的提现额度：");
        double limit = sc.nextDouble();
        acc.setLimit(limit);


        // 为账户生成随机卡号


        // 将账户添加进系统
        accounts.add(acc);
        System.out.println("恭喜您：" + acc.getUserName() + "，开户成功！");

    }


    // 生成8位的随机卡号
    private StringBuilder creatCardID() {
        // 创建字符串存放卡号
        StringBuilder cardID = new StringBuilder();
        Random r = new Random();
        // 循环8次随机数，将每一位追加到字符串
        for (int i = 0; i < 8; i++) {
            int data = r.nextInt(10);
            cardID.append(data);
        }
        // 判断是否与其他账户卡号重复


        return cardID;
    }

}


