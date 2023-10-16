import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Frame extends JFrame {

    SimpleDateFormat timeFormat;
    SimpleDateFormat dayFormat;
    SimpleDateFormat dateFormat;

    JLabel timeLabel;
    JLabel dayLabel;
    JLabel dateLabel;
    String time;
    String day;
    String date;
    Frame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Java Clock");
        this.setLayout(new FlowLayout());
        this.setSize(350,200);
        this.setResizable(false);


        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Verdana",Font.PLAIN,45));
        timeFormat = new SimpleDateFormat("hh:mm:ss a");

        dayLabel = new JLabel();
        dayLabel.setFont(new Font("Verdana",Font.PLAIN,40));
        dayFormat= new SimpleDateFormat("EEEE");

        dateLabel = new JLabel();
        dateLabel.setFont(new Font("Verdana",Font.PLAIN,30));
        dateFormat = new SimpleDateFormat("MMMMM / dd / yyyy");



        this.add(timeLabel);
        this.add(dayLabel);
        this.add(dateLabel);

        this.setVisible(true);

        setTime();
    }

    public void setTime(){
        while(true){
        time = timeFormat.format(Calendar.getInstance().getTime());
        timeLabel.setText(time);

        day = dayFormat.format(Calendar.getInstance().getTime());
        dayLabel.setText(day);

        date = dateFormat.format(Calendar.getInstance().getTime());
        dateLabel.setText(date);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
