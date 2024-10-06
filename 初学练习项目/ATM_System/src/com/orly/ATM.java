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
            System.out.println();
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
        System.out.println();
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
                    System.out.println();
                }
            }
            System.out.println();
        }
    }


    // 登陆后操作界面
    private void showUserCommand() {
        outerloop: while (true) {
            System.out.println();
            System.out.println("===尊敬的用户：" + loginAcc.getUserName() + "，您可以选择如下功能===");
            System.out.println("1.查询账户");
            System.out.println("2.存款");
            System.out.println("3.取款");
            System.out.println("4.转账");
            System.out.println("5.密码修改");
            System.out.println("6.退出账户");
            System.out.println("7.注销账户");
            System.out.println();
            System.out.println("0.退出登录");
            System.out.println("请输入您的操作：");
            int command = sc.nextInt();
            switch (command) {
                case 1:
                    // 查询当前账户信息
                    showLoginAccount();
                    break;
                case 2:
                    // 存款
                    depositMoney();
                    break;
                case 3:
                    // 取款
                    drawMoney();
                    break;
                case 4:
                    // 转账
                    transferMoney();
                    break;
                case 5:
                    // 密码修改
                    updatePasswd();
                    System.out.println("请重新登录此账户！");
                    return;
                case 6:
                    // 退出当前账户
                    System.out.println("===尊敬的用户：" + loginAcc.getUserName() + "，您已成功退出账户！");
                    return;
                case 7:
                    // 注销当前账户
                    if (deleteAccount()) {
                        // 销户成功，返回欢迎页面
                        return;
                    }
                    break;
                case 0:
                    // 返回
                    break outerloop;
                default:
                    System.out.println("ERROR!!!");
            }
            System.out.println();
        }
    }


    // 展示当前账户信息
    private void showLoginAccount() {
        System.out.println();
        System.out.println("===当前账户信息===");
        System.out.println("卡号：" + loginAcc.getCardID());
        System.out.println("户主：" + loginAcc.getUserName());
        System.out.println("性别：" + loginAcc.getSex());
        System.out.println("余额：" + loginAcc.getMoney());
        System.out.println("取现额度：" + loginAcc.getLimit());
        System.out.println();
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
        // TODO: 2024/10/6  System.out.println("请输入您的性别：");

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


    // 存款
    private void depositMoney() {
        System.out.println("===存款操作===");
        System.out.println("请您输入存款金额：");
        double money = sc.nextDouble();

        // 更新当前账户余额
        loginAcc.setMoney(loginAcc.getMoney() + money);
        System.out.println("您已成功存款" + money + "元！");
        System.out.println("您的账户余额为" + loginAcc.getMoney() + "元！");
    }


    // 取款
    private void drawMoney() {
        System.out.println("===取款操作===");
        if (loginAcc.getMoney() < 100) {
            System.out.println("ERROR！您的账户余额不足100元！");
            return;
        }
        while (true) {
            System.out.println("请您输入取款金额：");
            double money = sc.nextDouble();

            // 更新当前账户余额
            if (loginAcc.getMoney() >= money) {
                if (money <= loginAcc.getLimit()) {
                    loginAcc.setMoney(loginAcc.getMoney() - money);
                    System.out.println("您已成功取款" + money + "元！");
                    System.out.println("您的账户余额为" + loginAcc.getMoney() + "元！");
                    break;
                } else {
                    System.out.println("您当前取款金额超过单次限额！");
                    System.out.println("您当前取款限额为：" + loginAcc.getLimit() + "元！");
                }
            } else {
                System.out.println("余额不足！您的余额为：" + loginAcc.getMoney());
            }
        }
    }


    // 转账操作
    private void transferMoney() {
        System.out.println("===用户转账===");
        // 判断是否有其他账户
        if (accounts.size() < 2) {
            System.out.println("ERROR！当前系统内仅有一个账户，无法转账！");
            return;
        }
        // 判断账户内余额是否为0
        if (loginAcc.getMoney() == 0) {
            System.out.println("ERROR！您的账户内余额为0！");
            return;
        }

        // 转账操作
        while (true) {
            // 判断系统内是否有输入的账户
            System.out.println("请您输入待转账的卡号：");
            String cardID = sc.next();
            Account acc = getAccountByCardID(cardID);
            if (acc == null) {
                System.out.println("未找到您输入的账号，请重新输入：");
            } else if (acc == loginAcc) {
                System.out.println("请输入其他账户以进行转账操作！");
            } else {
                // 对用户进行账户名认证
                String name = acc.getUserName().substring(1);
                System.out.println("请认证您所要转账的账户名：*" + name);
                String preName = sc.next();
                if (acc.getUserName().startsWith(preName)) {
                    // 转账
                    while (true) {
                        System.out.println("请输入您想要转账的金额：");
                        double money = sc.nextDouble();
                        if (money <= loginAcc.getMoney()) {
                            loginAcc.setMoney(loginAcc.getMoney() - money);
                            acc.setMoney(acc.getMoney() + money);
                            System.out.println("转账成功，已向" + acc.getUserName() + "转账" + money + "元！");
                            System.out.println("您的余额为：" + loginAcc.getMoney() + "元!");
                            return;
                        } else {
                            System.out.println("您的余额不足，请重新输入金额！");
                            System.out.println("您的余额为：" + loginAcc.getMoney() + "元！");
                        }
                    }
                } else {
                    System.out.println("认证失败，请重新输入卡号！");
                }
            }
        }
    }


    // 销户操作
    private boolean deleteAccount() {
        System.out.println("===销户操作===");
        System.out.println("请问您确认销户吗？y/n");
        String command = sc.next();
        switch (command) {
            case "y":
                if (loginAcc.getMoney() == 0) {
                    accounts.remove(loginAcc);
                    System.out.println("您当前的账户已销户！");
                    return true;
                } else {
                    System.out.println("您的账户中余额不为0，不允许销户！");
                    return false;
                }
            default:
                System.out.println("取消销户操作！");
                return false;
        }
    }


    // 密码修改
    private void updatePasswd() {
        while (true) {
            System.out.println("===修改密码===");
            System.out.println("请输入当前账户密码：");
            String passwd = sc.next();
            if (loginAcc.getPassWord().equals(passwd)) {
                while (true) {
                    System.out.println("请输入新密码：");
                    String newPasswd = sc.next();
                    System.out.println("请确认新密码：");
                    String passwd_OK = sc.next();
                    if (newPasswd.equals(passwd_OK)) {
                        loginAcc.setPassWord(newPasswd);
                        System.out.println("您已成功修改密码！");
                        return;
                    } else {
                        System.out.println("您输入的密码不一致，请重新输入！");
                    }
                }

            } else {
                System.out.println("密码错误，请重新输入！");
            }
        }
    }

}


