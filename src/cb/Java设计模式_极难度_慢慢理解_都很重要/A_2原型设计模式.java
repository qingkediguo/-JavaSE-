package cb.Java设计模式_极难度_慢慢理解_都很重要;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
	原型模式(Prototype)：该模式的思想就是将一个对象作为原型，对其进行复制、克隆，产生一个和原对象类似的新对象。而这里的复制有两种：浅复制、深复制。
		浅复制：将一个对象复制后，基本数据类型的变量都会重新创建，而引用类型，指向的还是原对象所指向的。
		深复制：将一个对象复制后，不论是基本数据类型还有引用类型，都是重新创建的。
	简单来说，就是深复制进行了完全彻底的复制，而浅复制不彻底。
*/

// 【1、浅复制的核心是super.clone()，它调用的是Object的clone()方法，而在Object类中，clone()是native的。】
// 【2、要实现深复制，需要采用二进制流的形式写入当前对象，再对其进行读取。】

class Prototype implements Cloneable, Serializable {		// 由于这里涉及到对对象的读写，所以这里用到了对象的序列化--实现了Serializable接口 
    private static final long serialVersionUID = 1L;
    private int age;
    private int[] array = new int[] { 1, 2, 3 };
  
    public Prototype() {
    }
  
    public Prototype(int age) {
        this.age = age;
    }
  
    public int getAge() {  
        return age;
    }  
  
    public void setAge(int age) {  
        this.age = age;  
    }  
  
    public int[] getArray() {  
        return array;  
    }  
  
    public void setArray(int[] array) {  
        this.array = array;  
    }  

    /* 浅复制 */
    public Object shallowClone() throws CloneNotSupportedException {
    	Prototype sc = (Prototype) super.clone();
    	return sc;
    }
    
    /* 深复制 */  
    public Object deepClone() throws IOException, ClassNotFoundException {  
        /* 写入当前对象的二进制流 */  
        ByteArrayOutputStream bos = new ByteArrayOutputStream();  
        ObjectOutputStream oos = new ObjectOutputStream(bos);  
        oos.writeObject(this);  
  
        /* 读出二进制流产生的新对象 */  
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());  
        ObjectInputStream ois = new ObjectInputStream(bis);  
        return ois.readObject();  
    } 
}

public class A_2原型设计模式 {  
    public static void main(String[] args) throws IOException, ClassNotFoundException, CloneNotSupportedException {  
        Prototype prototype = new Prototype(20);  
        Prototype cloneProto = (Prototype) prototype.shallowClone();
        Prototype cloneProto1 = (Prototype) prototype.deepClone();  
        /** 
         * 通过打印可以看到：prototype和cloneProto这两个同一类型的变量指向的是两个不同的内存地址 
         *  
         * 这说明克隆成功 
         */  
        System.out.println("prototype = " + prototype);  
        System.out.println("cloneProto = " + cloneProto);
        System.out.println("cloneProto = " + cloneProto1);
        /** 
         * 通过打印可以看到，两个对象的引用类型变量array指向的是不同的内存地址 
         *  
         * 这说明对象进行了完全彻底的复制 
         */  
        System.out.println("prototype.getArray() = " + prototype.getArray());
        System.out.println("cloneProto.getArray() = " + cloneProto.getArray());
        System.out.println("cloneProto.getArray() = " + cloneProto1.getArray());
  
        /** 
         * 当然我们也可以试着打印一下引用变量的内容， 
         *  
         * 可以看到：内容是不变的(1 2 3)，改变的只是引用变量指向的内存地址。 
         */  
        int[] proArray = prototype.getArray();  
        int[] cloneProtoArray = cloneProto.getArray(); 
        int[] cloneProtoArray1 = cloneProto1.getArray();
        for (int p : proArray) {  
            System.out.print(p + "\t");  
        }  
        System.out.println();  
        for (int p : cloneProtoArray) {  
            System.out.print(p + "\t");  
        }  
        System.out.println();  
        for (int p : cloneProtoArray1) {  
            System.out.print(p + "\t");  
        }
    }  
}