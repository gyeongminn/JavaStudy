package 기말프로젝트;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Graphics;

import java.awt.Point;

class PanelA extends JPanel {
    JLabel label = new JLabel();
    String Pbutton;
    Shape shape;
    Point start = null; //스타트 변수
    Point end = null;//엔드 변수
    int offX, offY;
    ArrayList<Shape> shapes = new ArrayList<Shape>();
    PanelA() {
        setBackground(Color.YELLOW);
        setLayout(null);
        addMouseListener(new MyMouseAdapter());
        addMouseMotionListener(new MyMouseAdapter());
    }


    class MyMouseAdapter extends MouseAdapter {
        Shape selectedShape = null;
        public void mousePressed(MouseEvent e) {

            start = e.getPoint();
            if(shapes!=null&&selectedShape==null) {
                for(int i=0;i<shapes.size();i++) {
                    if(shapes.get(i).meet(e.getX(), e.getY())) {

                    }
                }
                end = null;
                if (selectedShape != null) {//도형선택
                    selectedShape.p1Selected = false;//초기화
                    selectedShape.p2Selected = false;//초기화

                    Point p1 = selectedShape.getP1();//p1은 control point의 첫번째 점
                    Point p2 = selectedShape.getP2();//p2는 control point의 두번째 점

                    if (e.getX() - 10   < p1.getX() && p1.getX() < e.getX() + 10 &&
                            e.getY() - 10   < p1.getY() && p1.getY() < e.getY() + 10) {
                        selectedShape.p1Selected = true;//control   point
                    }
                    if (e.getX() - 10   < p2.getX() && p2.getX() < e.getX() + 10 &&
                            e.getY() - 10   < p2.getY() && p2.getY() < e.getY() + 10) {
                        selectedShape.p2Selected = true;//control   point
                    }
                }
            }
        }
        public void mouseReleased(MouseEvent e) {
            if (selectedShape != null) {//도형 선택
                selectedShape.p1Selected = false;//초기화
                selectedShape.p2Selected = false;//초기화
            }
            selectedShape = null;//선택한 도형 초기화
            if (Pbutton.equals("복사") || Pbutton.equals("삭제")) { //복사 또는 삭제를 클릭하면
                for (int i = 0; i < shapes.size(); i++) {
                    Shape s = (Shape) shapes.get(i);
                    if (s.meet(e.getX(),e.getY())) {//저장된 도형을 클릭하면
                        selectedShape = (Shape)
                        break;
                    }
                }
                if (Pbutton.equals("복사")) {   //복사 선택시
                    selectedShape.isSelected = true;//선택된 도형을 control point로

                    if (selectedShape instanceof Rectangle) {
                        Rectangle rec = (Rectangle) selectedShape;//선택된 도형의 정보
                        Rectangle   copyRec = new Rectangle(rec.x + 10,rec.y + 10, rec.width, rec.height);
                        shapes.add(copyRec);//가로 10, 세로 10만큼 이동된 후 복사됨
                    }
                    else if (selectedShape instanceof Line) {
                        Line line = (Line) selectedShape;//선택된 도형의 정보
                        Line copiedLine = new Line(line.x + 10, line.y,   line.x2 + 10, line.y2);
                        shapes.add(copiedLine);//가로 10로 이동 후 복사됨
                    }
                    else if (selectedShape instanceof Elipse) {
                        Elipse elipse = (Elipse) selectedShape;//선택된 도형의 정보
                        Elipse copiedEl = new Elipse(elipse.x + 10, elipse.y + 10, elipse.width, elipse.height);
                        shapes.add(copiedEl);//가로 10, 세로 10만큼 이동한 후 복사됨
                    }
                }
                else if(Pbutton.equals("삭제")){
                    shapes.remove(selectedShape);//선택된 도형을 삭제함
                }

                repaint();
            }
        }

         else{
            selectedShape = null;//선택한 도형 초기화
            for (int i = 0; i < shapes.size(); i++) {
                Shape s = (Shape) shapes.get(i);
                s.isSelected = false;//패널을 클릭해서 선택 해제
            }
            for (int i = 0; i < shapes.size(); i++) {
                Shape s = (Shape) shapes.get(i);
                if (s.meet(e.getX(), e.getY())) {//도형 안을 클릭을 하면
                    selectedShape = s;
                    s.isSelected = true;//선택된 도형의 control point생성
                    break;
                }
            }
            repaint();
        }
         if (selectedShape != null) {//도형을 선택하였을 경우
            start = null;
            return;
        }
            if (start == null)
                return;
        end = e.getPoint();
        int x = Math.min(start.x, end.x);
        int y = Math.min(start.y, end.y);
        int width = Math.abs(start.x - end.x);
        int height = Math.abs(start.y - end.y);
            if(Pbutton.equals("사각")) {//사각버튼 선택 시
            shape = new Rectangle(x,y,width,height);   //사각형 생성
        }
         else if(Pbutton.equals("직선")) {   //직선버튼 선택 시
            shape = new Line(start.x,start.y,end.x,end.y); //직선 생성
        }
         else if(Pbutton.equals("타원")) {  //타원버튼 선택 시
            shape = new Elipse(x,y,width,height);    //타원 생성
        }
            shapes.add(shape); //도형이 만들어지면 shape에 하나씩 추가
        start = null;
        repaint();
    }
    public void   mouseDragged(MouseEvent e) {
        if (selectedShape == null) {//선택된 도형이 없으면
            end = e.getPoint();
        }
        else {//도형이 선택되면
            start = null;
            if (!(selectedShape.p1Selected || selectedShape.p2Selected)) {//도형 이동
                if (selectedShape instanceof Rectangle) {//선택된 도형이 사각형이면

                    Rectangle   r = (Rectangle) selectedShape;
                    r.x = e.getX();
                    r.y = e.getY();
                }   //x와y좌표 조절해서 이동
                else if (selectedShape instanceof Elipse) {//선택된 도형이 타원이면
                    Elipse el = (Elipse) selectedShape;
                    el.x = e.getX();
                    el.y = e.getY();
                }   //x와y좌표 조절해서 이동
                else if (selectedShape instanceof Line) {//선택된 도형이 선이면

                    Line   l = (Line) selectedShape;
                    Point   incL = l.getIncXY();//끝점에서 시작점의 좌표를 뻄
                    l.x = e.getX();
                    l.y = e.getY();
                    l.x2 = (int) (e.getX() + incL.getX());
                    l.y2 = (int) (e.getY() + incL.getY());
                }//도형 이동
            }
            else {//도형 크기 변경
                if (selectedShape.p1Selected) {//control   point의 첫번째 점을 클릭 시
                    if (selectedShape instanceof Rectangle) {//선택된 도형이 사각형이면

                        Rectangle r = (Rectangle)

                        int incX = r.x - e.getX();
                        int incY = r.y - e.getY();
                        r.x = e.getX();
                        r.y = e.getY();
                        r.width +=incX;
                        r.height +=incY;
                    }   //크기조절
                    else if (selectedShape instanceof Elipse) {//선택된 도형이 타원이면

                        Elipse el = (Elipse) selectedShape;
                        int incX = el.x - e.getX();
                        int incY = el.y - e.getY();
                        el.x = e.getX();
                        el.y = e.getY();
                        el.width += incX;
                        el.height += incY;
                    }   //크기조절

                    else if (selectedShape instanceof Line) {//선택된 도형이 선이면
                        Line l = (Line) selectedShape;
                        l.x = e.getX();
                        l.y = e.getY();

                    }//크기조절
                }

                else if (selectedShape.p2Selected) {//control   point의 두번째 점을 클릭했을 때
                    if (selectedShape instanceof Rectangle) {//선택된 도형이 사각형이면
                        Rectangle   r = (Rectangle) selectedShape;
                        r.width = e.getX() - r.x;
                        r.height = e.getY() - r.y;
                    }//크기조절
                    else if (selectedShape instanceof Elipse) {//선택된 도형이 타원이면
                        Elipse el = (Elipse) selectedShape;
                        el.width = e.getX() - el.x;
                        el.height = e.getY() - el.y;
                    }//크기조절

                    else if (selectedShape instanceof Line) {//선택된 도형이 선이면
                        Line l = (Line) selectedShape;
                        l.x2 = e.getX();
                        l.y2 = e.getY();
                    }//크기조절
                }
            }
        }
        repaint();
    }
}
    public void paintComponent(Graphics g) {
        super.paintComponent(g); // 새로 그림
        // 저장된 값 불러오기
        for (int i = 0; i < shapes.size(); i++) {
            ((Shape)shapes.get(i)).draw(g);//그린 도형을 저장
        }
        if (start == null)
            return;
        g.setColor(Color.BLUE);
        int x = Math.min(start.x, end.x);
        int y = Math.min(start.y, end.y);
        int width = Math.abs(start.x - end.x);
        int height = Math.abs(start.y - end.y);
        if(Pbutton.equals("사각")) {  //사각 선택시
            g.drawRect(x,y,width,height);//사각형을 그림
        }

        else if(Pbutton.equals("직선")) {  //직선 선택시
            g.drawLine(start.x,start.y,end.x,end.y);//선을 그린다
        }
        else if(Pbutton.equals("타원")) {  //타원 선택시
            g.drawOval(x,y,width,height);//타원을 그린다
        }
        else if(Pbutton.equals("저장"));
    }