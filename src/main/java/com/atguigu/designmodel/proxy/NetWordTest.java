/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/11 02:24
 */

package com.atguigu.designmodel.proxy;

public class NetWordTest {

    public static void main(String[] args){
        
        new ProxyServer(new Server()).browse();
                
    }

}

interface NetWrok{

    void browse();

}

//被代理类
class Server implements NetWrok{

    @Override
    public void browse() {
        System.out.println("Server .. browse ");
    }
}

class ProxyServer implements NetWrok{

    private NetWrok netWrok;

    public ProxyServer(NetWrok netWrok) {
        this.netWrok = netWrok;
    }

    public void check(){
        System.out.println("ProxyServer .. check ");
    }

    @Override
    public void browse() {
        check();
        netWrok.browse();
    }
}