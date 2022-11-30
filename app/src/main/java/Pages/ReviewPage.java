package Pages;

import DTO.ReviewDTO;
import DTO.StoreDTO;
import HTTP.ReviewHTTP;
import Setting.SingleTon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
public class ReviewPage extends JFrame implements ActionListener{
    ReviewHTTP httpReview=new ReviewHTTP();
    JTextArea textTitle;
    ReviewDTO myReview;
    JTextArea textReview;
    public ReviewPage(){
        try{
            ReviewPage();
        } catch (Exception e){
        }
    }
    public void ReviewPage(){
        setTitle("ReviewPage");
        setSize(1280,720);

        String STORELABELTEST = "맘스터치 동의대 지천관점";

        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font mainFont40 = new Font("배달의민족 도현",Font.PLAIN,40);   //폰트 설정
        Font mainFont30 = new Font("배달의민족 도현",Font.PLAIN,30);
        Font mainFont26 = new Font("배달의민족 도현",Font.PLAIN,26);
        Font mainFont22 = new Font("배달의민족 도현",Font.PLAIN,22);
        Font mainFont18 = new Font("배달의민족 도현",Font.PLAIN,18);

        Color mint = new Color(62,185,180); //색상 정하기
        Color gray1 = new Color(192,192,192);

        JPanel panelMainWhite = new JPanel();
        panelMainWhite.setBounds(30,30,1204,614);
        panelMainWhite.setBackground(Color.white);

        JPanel panelMainMint = new JPanel();
        panelMainMint.setBounds(322,30,620,80);
        panelMainMint.setBackground(mint);

        JLabel mainLabel = new JLabel("오점뭐 (오늘 점심 뭐 먹지)");
        mainLabel.setHorizontalAlignment(JLabel.CENTER);
        mainLabel.setBounds(382,30,500,70);         //나머지 페이지들도 적용
        mainLabel.setFont(mainFont40);

        JLabel labelStore = new JLabel(STORELABELTEST);
        labelStore.setHorizontalAlignment(JLabel.CENTER);
        labelStore.setBounds(382,100,500,100);
        labelStore.setFont(mainFont22);

        textTitle = new JTextArea("제목");
        textTitle.setBounds(297,182,670,50);
        textTitle.setFont(mainFont22);
        textTitle.setForeground(gray1);

        textReview = new JTextArea("리뷰 내용");
        textReview.setBounds(297,242,670,227);
        textReview.setFont(mainFont22);
        textReview.setForeground(gray1);

        JPanel panelReviewGray = new JPanel();
        panelReviewGray.setBounds(288,177,688,306);
        panelReviewGray.setBackground(gray1);

       /* JPanel panelReviewWhite = new JPanel();
        panelReviewWhite.setBounds(292,180,680,300);
        panelReviewWhite.setBackground(Color.gray);*/

        JButton buttonDone = new JButton("-리뷰 작성-");
        buttonDone.setBounds(532,510,200,34);
        buttonDone.setFont(mainFont22);
        buttonDone.setBorderPainted(false);         //버튼 테두리 없에기
        buttonDone.setContentAreaFilled(false);     //버튼 내부 색 채움 여부
        //buttonDone.setFocusPainted(false);        //버튼 포커스(클릭시 테두리)
        buttonDone.setActionCommand("Write");
        buttonDone.addActionListener(this);

        JButton buttonBack = new JButton("뒤로가기");
        buttonBack.setBounds(572,560,120,30);
        buttonBack.setFont(mainFont18);
        buttonBack.setBorderPainted(false);         //버튼 테두리 없에기
        buttonBack.setContentAreaFilled(false);     //버튼 내부 색 채움 여부
        //buttonBack.setFocusPainted(false);        //버튼 포커스(클릭시 테두리)
        buttonBack.setActionCommand("BackPage");
        buttonBack.addActionListener(this);

        getContentPane().add(buttonBack);
        getContentPane().add(labelStore);
        getContentPane().add(buttonDone);
        getContentPane().add(textReview);
        getContentPane().add(mainLabel);
        getContentPane().add(textTitle);
        //getContentPane().add(panelReviewWhite);
        getContentPane().add(panelReviewGray);
        getContentPane().add(panelMainMint);
        getContentPane().add(panelMainWhite);
        getContentPane().setBackground(mint);

        setResizable(false);    //화면 크기 고정
        setVisible(true);

    }
    public void actionPerformed(ActionEvent e) {

        String event = e.getActionCommand();

        if (event.equals("Write")) {
            try {
                ReviewDTO wr = ReviewDTO.builder()
                        .title(textTitle.getText())
                        .content(textReview.getText())
                        .upk(SingleTon.getUser().getUpk())
                        .spk(StoreDetail.currentStore.getSpk())
                        .build();
                myReview=(httpReview.createReview(wr));
                if(myReview!=null) {
                    JOptionPane.showMessageDialog(null, "내 리뷰가 등록되었습니다.");
                }
            } catch (IOException t) {}
        }
        if (event.equals("BackPage")) {
            this.setVisible(false);
            StoreDetail SD=new StoreDetail();
        }
    }
}
