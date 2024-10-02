package com.orly;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class ATM {
    private ArrayList<Account> accounts = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    private Account loginAcc;

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
                    login();
                    break;
                case 2:
                    creatAccount();
                    break;
                case 0:
                    break outerLoop;
                default:
                    System.out.println("ERROR！！！");
            }
            System.out.println();
        }
    }


    // 账户登录
    private void login() {
        System.out.println("===系统登录===");
        // 若系统内不存在用户，则跳出方法
        if (accounts.isEmpty()) {
            System.out.println("当前系统中无账户，请开户后再尝试登录！");
            return;
        }
        while (true) {
            System.out.println("请输入您的卡号：");
            String cardID = sc.next();
            Account acc = getAccountByCardID(cardID);
            if (acc == null) {
                System.out.println("您输入的卡号不存在，请确认卡号！");
            } else {
                while (true) {
                    System.out.println("请输入您的密码：");
                    String password = sc.next();
                    if (acc.getPassWord().equals(password)) {
                        loginAcc = acc;
                        System.out.println("恭喜您：" + acc.getUserName() + "，登陆成功！您的卡号为：" + acc.getCardID());
                        showUserCommand();
                        return;
                    } else {
                        System.out.println("输入的密码错误，请重新输入！");
                    }
                }
            }
        }
    }


    // 登陆后操作界面
    private void showUserCommand() {
        while (true) {
            System.out.println("===" + loginAcc.getUserName() + "您可以选择如下功能===");
            System.out.println("1.查询账户");
            System.out.println("2.存款");
            System.out.println("3.取款");
            System.out.println("4.转账");
            System.out.println("5.密码修改");
            System.out.println("6.退出账户");
            System.out.println("7.注销账户");
            System.out.println("请输入您的操作：");
            int command = sc.nextInt();
            switch (command) {
                case 1:
                    // 查询当前账户信息
                    showLoginAccount();
                    break;
                case 2:
                    // 存款
                    break;
                case 3:
                    // 取款
                    break;
                case 4:
                    // 转账
                    break;
                case 5:
                    // 密码修改
                    break;
                case 6:
                    // 退出当前账户
                    System.out.println(loginAcc.getUserName() + "您已成功退出账户！");
                    return;
                case 7:
                    // 注销当前账户
                    break;
                default:
                    System.out.println("ERROR!!!");
            }
        }
    }


    // 展示当前账户信息
    private void showLoginAccount() {
        System.out.println("===当前账户信息===");
        System.out.println("卡号：" + loginAcc.getCardID());
        System.out.println("户主：" + loginAcc.getUserName());
        System.out.println("性别：" + loginAcc.getSex());
        System.out.println("余额：" + loginAcc.getMoney());
        System.out.println("取现额度：" + loginAcc.getLimit());
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


        // 添加卡号到账户对象
        acc.setCardID(creatCardID());
        System.out.println("您的卡号为：" + acc.getCardID());


        // 将账户添加进系统
        accounts.add(acc);
        System.out.println("恭喜您：" + acc.getUserName() + "，开户成功！");

    }


    // 生成8位的随机卡号
    private String creatCardID() {
        // 创建字符串存放卡号
        String cardID = "";
        Random r = new Random();
        // 循环8次随机数，将每一位追加到字符串
        for (int i = 0; i < 8; i++) {
            int data = r.nextInt(10);
            cardID += data;
        }
        // 判断是否与其他账户卡号重复
        while (true) {
            Account acc = getAccountByCardID(cardID);
            if (acc == null) {
                return cardID;
            }
        }
    }


    // 根据卡号查询是否有重复的账户对象
    private Account getAccountByCardID(String cardID) {
        for (int i = 0; i < accounts.size(); i++) {
            Account acc = accounts.get(i);
            if (acc.getCardID().equals(cardID)) {
                return acc;
            }
        }
        return null;
    }

}


