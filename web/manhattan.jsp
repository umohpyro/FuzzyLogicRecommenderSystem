<%@ page import ="java.sql.*" %>
<%@ page import="includes.*" %>
<%
int i;
    try{
        String userid = session.getAttribute("userid").toString();
        Connection con = DoConnection.getConnection();
        Statement st = con.createStatement();
        ResultSet rs;
        i = st.executeUpdate("create table temp(pname varchar(45),val number(20))");
        rs = st.executeQuery(" select * from items i1,items i2 where i1.uname='"+session.getAttribute("userid")+"' and i2.uname!='"+session.getAttribute("userid")+"'");
        if (rs.next()) {

            session.setAttribute("userid", userid);
            //out.println(rs.getString(1));
            //out.println(rs.getInt(2));
            //out.println(rs.getInt(3));
            //out.println(rs.getInt(4));
            //out.println(rs.getInt(5));
            //out.println(rs.getInt(6));
            //out.println(rs.getInt(7));
            //out.println(rs.getString(8));
            //out.println(rs.getInt(9));
            //out.println(rs.getInt(10));
            //out.println(rs.getInt(11));
            //out.println(rs.getInt(12));
            //out.println(rs.getInt(13));
            //out.println(rs.getInt(14));

            String new1=rs.getString(8);

            int a=0,b=0,d=0,j=0;
            double c;


            for(i=2,j=9;i<=7&&j<=14;i++,j++)
            {
                d=d+Math.abs(rs.getInt(i)-rs.getInt(j));
            }
            c=d;
//	out.println(c);

            i = st.executeUpdate("commit");
            i = st.executeUpdate("insert into temp values('"+new1+"','"+c+"')");
            i = st.executeUpdate("commit");
//	out.println(a*b/Math.sqrt(a*b));

        }
        rs = st.executeQuery(" select * from temp where val=(select max(val) from temp)");
        String new2;
        if (rs.next()) {
//out.println(rs.getString(1));
//out.println(rs.getInt(2));
            new2=rs.getString(1);
            ResultSet rs1 = st.executeQuery(" select * from items i1,items i2 where i2.uname='"+new2+"'");
            if (rs1.next()) {
                out.println("<h1>Movies recommended for you: </h1>");
                for(i=2;i<=7;i++)
                {
                    int p=rs1.getInt(i);
                    int q=rs1.getInt(i+7);
                    if(q!=0)
                    {
                        out.println("<img src='img/" + (i-1) + ".jpg'>");
                    }
                }
            }
            else{
                out.println("No recommendations for you..!");
            }
        }


        i = st.executeUpdate("drop table temp");
        i = st.executeUpdate("commit");

    }catch(Exception e){
        out.println(e);
    }
%>