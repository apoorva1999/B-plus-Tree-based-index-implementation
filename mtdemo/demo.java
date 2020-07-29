
import java.util.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class demo {
    static JFrame win;
    static JButton b1;
    static JButton b2;
    static JTextField t1;
    static JLabel l1;

    public static void main(String[] args){
        win = new JFrame();

        win.setTitle("RDBMS Index Implementation");
		win.setExtendedState(JFrame.MAXIMIZED_BOTH);
        win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        b1 = new JButton();
		b1.setFont(new Font("Monospaced", 0, 50)); // NOI18N
		b1.setText("NMT Fire");
        b1.addActionListener(new NMTActionHandler());
        
        b2 = new JButton();
		b2.setFont(new Font("Monospaced", 0, 50)); // NOI18N
		b2.setText("MT Fire");
        b2.addActionListener(new MTActionHandler());

		t1 = new JTextField("");
		t1.setColumns(10);
        t1.setFont(new Font("Monospaced", 0, 50)); // NOI18N
        
        l1 = new JLabel();
		l1.setFont(new Font("Monospaced", 0, 50)); // NOI18N
		l1.setForeground(new Color(0, 0, 0));
		l1.setText("Time = ??");

		win.setLayout(new GridLayout(2, 2));
        win.add(b1);
        win.add(b2);
        win.add(t1);
        win.add(l1);

        win.setVisible(true);
    }


    static int Fib(int n){
        if(n == 0 || n== 1){
            return n;
        }
        return Fib(n - 1) + Fib(n - 2);
    }

    public static class NMTActionHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            long start = System.currentTimeMillis();
            Fib(47);
            long end = System.currentTimeMillis();
            long duration = (end - start) / 1000;
            l1.setText(duration + "");
        }
    }

    public static class MTActionHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            ThreadTarget tt = new ThreadTarget();
            Thread t = new Thread(tt);
            t.start();
        }
    }

    public static class ThreadTarget implements Runnable {
        public void run(){
            long start = System.currentTimeMillis();
            Fib(47);
            long end = System.currentTimeMillis();
            long duration = (end - start) / 1000;
            l1.setText(duration + "");
        }
    }
}