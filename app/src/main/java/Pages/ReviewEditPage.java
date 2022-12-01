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

public class ReviewEditPage extends JFrame implements ActionListener {
    ReviewHTTP httpReview=new ReviewHTTP();
    JTextArea textTitle;
    ReviewDTO myReview;
    ReviewDTO originReview;
    JTextArea textReview;
    //static ReviewDTO originReview;
    public ReviewEditPage(ReviewDTO originReview){
        try{
            ReviewPage(originReview);
        } catch (Exception e){
        }
    }
    public void ReviewPage(ReviewDTO originReview){
        this.originReview=originReview;
        setTitle("ReviewPage");
        setSize(1280,720);

        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

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

        JLabel labelStore = new JLabel("EDIT");
        labelStore.setHorizontalAlignment(JLabel.CENTER);
        labelStore.setBounds(382,100,500,100);
        labelStore.setFont(mainFont22);

        JPanel panelReviewWhiteTitle = new JPanel();
        panelReviewWhiteTitle.setBounds(284,182,696,50);
        panelReviewWhiteTitle.setBackground(Color.white);

        textTitle = new JTextArea(originReview.getTitle());
        textTitle.setBounds(288,190,688,42);
        textTitle.setFont(mainFont22);
        textTitle.setForeground(gray1);

        JPanel panelReviewWhiteReview = new JPanel();
        panelReviewWhiteReview.setBounds(284,234,696,244);
        panelReviewWhiteReview.setBackground(Color.white);

        textReview = new JTextArea(originReview.getContent());
        textReview.setBounds(288,238,688,240);
        textReview.setFont(mainFont22);
        textReview.setForeground(gray1);

        JPanel panelReviewGray = new JPanel();
        panelReviewGray.setBounds(282,180,700,300);
        panelReviewGray.setBackground(gray1);


        JButton updateReview=new JButton("수정");
        updateReview.setBounds(520,510,100,34);
        updateReview.setFont(mainFont22);
        updateReview.setBackground(mint);
        updateReview.setBorderPainted(false);         //버튼 테두리 없에기
        updateReview.setActionCommand("UpdateReview");
        updateReview.addActionListener(this);

        JButton deleteReview=new JButton("삭제");
        deleteReview.setBounds(630,510,100,34);
        deleteReview.setFont(mainFont22);
        deleteReview.setBackground(mint);
        deleteReview.setBorderPainted(false);         //버튼 테두리 없에기
        deleteReview.setActionCommand("DeleteReview");
        deleteReview.addActionListener(this);

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
        getContentPane().add(updateReview);
        getContentPane().add(deleteReview);
        getContentPane().add(textReview);
        getContentPane().add(mainLabel);
        getContentPane().add(textTitle);
        getContentPane().add(panelReviewWhiteTitle);
        getContentPane().add(panelReviewWhiteReview);
        getContentPane().add(panelReviewGray);
        getContentPane().add(panelMainMint);
        getContentPane().add(panelMainWhite);
        getContentPane().setBackground(mint);

        setResizable(false);    //화면 크기 고정
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {

        String event = e.getActionCommand();

        if (event.equals("UpdateReview")) {
            try {
                ReviewDTO ur = ReviewDTO.builder()
                        .title(textTitle.getText())
                        .content(textReview.getText())
                        .upk(originReview.getUpk())
                        .spk(originReview.getSpk())
                        .rpk(originReview.getRpk())
                        .build();
                myReview=(httpReview.updateeview(ur));
                if(myReview!=null) {
                    JOptionPane.showMessageDialog(null, "내 리뷰가 수정되었습니다.");
                }
            } catch (IOException t) {}
        }
        else if(event.equals("DeleteReview")){
            try {
                httpReview.deleteReview(originReview);
                JOptionPane.showMessageDialog(null, "리뷰가 삭제되었습니다.");
            } catch (IOException t) {}
        }
        else if (event.equals("BackPage")) {
            dispose();
            StoreDetail SD=new StoreDetail();
        }
    }
}
