package com.example.demo.designpattern.builder;

/**
 * @author zhangxiaofeng
 * @Describetion
 * @date 2019/3/2210:35
 */
public class Main {

    public static void main(String[] args) {
        if (args.length != 1) {
            usage();
            System.exit(0);
        }
        Director director = null;
        if (args[0].equals("plain")) {
            TextBuilder textBuilder = new TextBuilder();
            director = new Director(textBuilder);
            director.construct();
            String result = textBuilder.getResult();
            System.out.println(result);
        }else if(args[0].equals("html")){
            HTMLBuilder htmlBuilder = new HTMLBuilder();
            director = new Director(htmlBuilder);
            director.construct();
            String result = htmlBuilder.getResult();
            System.out.println(result);
        }else{
            usage();
            System.exit(0);
        }
    }

    public static void usage(){
        System.out.println("Usage: java Main plain");
        System.out.println("Usage: java Main html");
    }
}
