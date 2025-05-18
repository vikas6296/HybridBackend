/*
package abound.neobank.utilities;

import com.aventstack.extentreports.ExtentTest;
import com.jcraft.jsch.*;
import org.testng.Assert;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Paths;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Random;

import static abound.neobank.services.SignupAndKycFlow.userIdOfTc;
import static abound.neobank.services.SignupAndKycFlow.validEmail;

public class DBUtils
{
    public static Connection con;

    public static String T1;
    public static String T2;
    public static String T3;
    public static String T4;
    public static String T5;



    static {

        String jumpserverHost = "3.208.52.181";
        String jumpserverUsername = "vikas.kumar";

        String databaseHost = "timesclub-staging.chfxowrcr4sp.us-east-1.rds.amazonaws.com";

        int databasePort = 3306;
        String databaseUsername = "timesuser";
        String databasePassword = "TimesClubUat123";

        JSch jsch = new JSch();
        String HOME = "C:\\Users\\vikas.kumar5";
        System.out.println("======="+HOME);
        String knownHostsFileName = Paths.get(HOME, ".ssh", "known_hosts").toString();
        String identity = Paths.get(HOME, ".ssh", "id_rsa").toString();
        System.out.println("identity name"+identity);

        // String knownHostsFileName = Paths.get("/Users/Shivani.Sinha/", "docs", "known_hosts").toString();
        // String identity = Paths.get("/Users/Shivani.Sinha/", "docs", "id_rsa").toString();
        // System.out.println("knownHostsFileName: " + knownHostsFileName);


        System.out.println("knownHostsFileName: " + knownHostsFileName);// print file name

        if (knownHostsFileName != null && new File(knownHostsFileName).exists()) {
            try {
//                jsch.setKnownHosts(knownHostsFileName);
                jsch.addIdentity(identity,"Vikas@9910");
                System.out.println("iddentity file loaded successfully");
            } catch (JSchException e) {
                e.printStackTrace();
            }
            System.out.println("KnownHostsFile added");
        }


//        try {
//            jsch.addIdentity(identity, "Abound@123");
//        } catch (JSchException e) {
//            e.printStackTrace();
//        }

        // Connect to SSH jump server (this does not show an authentication code)
        Session session = null;
        try {
            session = jsch.getSession(jumpserverUsername, jumpserverHost);
        } catch (JSchException e) {
            e.printStackTrace();
        }
        java.util.Properties config = new java.util.Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config);
        System.out.println("connecting..");
        try {
            session.connect();
        } catch (JSchException e) {
            System.out.println("exception is ====="+e);
//            e.printStackTrace();
        }catch (Exception e){
            System.out.println("exception is 2 ====="+e);
        }
        System.out.println("connected");

        // Forward randomly chosen local port through the SSH channel to database host/port
        int forwardedPort = 0;
        try {

            forwardedPort = session.setPortForwardingL(9094, databaseHost, databasePort);
            System.out.println("try test block");
        } catch (JSchException e) {
            e.printStackTrace();
        }
        System.out.println("port forwarded" + forwardedPort);

      //  String url = "jdbc:mysql://127.0.0.1:"+forwardedPort+"/tc_neobank2";//jdbc:mysql://10.0.150.90:3306/times
        //jdbc:mysql://127.0.0.1:9095/times
   //     String url = "jdbc:mysql://timesclub-staging.chfxowrcr4sp.us-east-1.rds.amazonaws.com:3306/tc_neobank_dev";

        String url = "jdbc:mysql://127.0.0.1:"+forwardedPort+"/tc_neobank_dev";//jdbc:mysql://10.0.150.90:3306/times
        //jdbc:mysql://127.0.0.1:9095/times
        try {

            con = DriverManager.getConnection(url, databaseUsername, databasePassword);
            System.out.println("connected database");
            Statement st = con.createStatement();
            //String sql = "UPDATE users " +
            //"SET email = 'subsa1@mailtrap.io' WHERE email='subsa11@mailtrap.io'";

            //int update = st.executeUpdate(sql);
            //if (update >= 1) {
            //System.out.println("Row is updated.");
            // }



            //*************

//            try {
//            	System.out.println("delete port");
//				session.delPortForwardingL(9095);
//			} catch (JSchException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}


        } catch (SQLException e) {
            e.printStackTrace();
        }



    }


    public static int updateRow(String query) throws SQLException {
        Statement st = con.createStatement();
        return  st.executeUpdate(query);
    }

   */
/* public static String SelectRow(String query) throws SQLException {
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
//        while (rs.next()) {
//            String account_id = rs.getString("account_id");
//        }
        //return  st.executeQuery(query).getString("account_id");
        rs.first();
        String account_id = rs.getString("account_id");

        return account_id;
    }*//*



    public static String createTxn(int userId){

        return "insert into wallet_history (amount,amounttype,store_name,item_id,entry_time,user_id,is_pending,remark,cashback,maturity_date,spent_amount,transaction_type,partner_transaction_status,status,merchant_name) values(12,'e','MoneyGram','Finance',now(),"+userId+",1,'$12 Earned. $78.5 Spent.','cashback',now(),78.50,'EARNED','PARTNER_APPROVED','CONFIRMED_CASHBACK','Touchstone');";

    }

    public static String markBankInvalid(int userId) {

        return "update plaid_accounts set invalid=1 where user_id=" +userId+ ";";
    }

    public static String getCard() throws SQLException

    {

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select account_id from plaid_accounts where user_id=343263 and account_subtype='MASTERCARD' and deleted is null");
//        while (rs.next()) {
//            String account_id = rs.getString("account_id");
//        }
        //return  st.executeQuery(query).getString("account_id");
        rs.first();
        String account_id = rs.getString("account_id");
        return account_id;

    }

    public static String mockedDataFailedDueToIncorrectValue() throws SQLException, InterruptedException {
        Thread.sleep(1000);
        Statement st = con.createStatement();
     //   ResultSet rs = st.executeQuery("select id from user where email ='"+validEmail+"';");
//        rs.first();
//        String userId=rs.getString("id");

        ResultSet transactionRefId = st.executeQuery("select transaction_ref_id from remittance_transaction_step_status where user_id=5210;");
        transactionRefId.last();
        T1=transactionRefId.getString(1);

        st.executeUpdate("update remittance_transaction_step_status set destination_amount=2000000 where user_id=5210 and transaction_ref_id="+T1+";");

        st.executeUpdate("update QRTZ_TRIGGERS set NEXT_FIRE_TIME=PREV_FIRE_TIME where  TRIGGER_NAME='TransactionApprovalJob';");

        Thread.sleep(10000);

        ResultSet cashOutStatus=st.executeQuery("select cash_out_status from remittance_transaction_step_status where transaction_ref_id='"+T1+"';");
        if(cashOutStatus.next()){
            return cashOutStatus.getString(1);
        }
        return  cashOutStatus.getString(1);

    }


    public static void bankRelinkCase() throws SQLException {
        Statement st = con.createStatement();
        st.executeUpdate("update plaid_accounts set invalid=1 where user_id="+userIdOfTc+";");

    }


    public static String mockingUnableToBookFx() throws SQLException, InterruptedException {
        Thread.sleep(1000);
        Statement st = con.createStatement();
//        System.out.println("sql query --> "+"select id from user where email='"+validEmail+"';");
//        ResultSet rs = st.executeQuery("select id from user where email='"+validEmail+"';");

//        rs.first();
//        String userId=rs.getString("id");

        ResultSet transactionRefId = st.executeQuery("select transaction_ref_id from remittance_transaction_step_status where user_id=5210;");
        transactionRefId.last();
       T2=transactionRefId.getString(1);


        st.executeUpdate("update remittance_transaction_step_status set effective_fx_rate=-1 where user_id=5210 and transaction_ref_id="+T2+";");
        //st.executeUpdate("update user_fx_hold_rate_data set fx_hold_end_time=1683633690000 where user_id="+userId+";");




        st.executeUpdate("update QRTZ_TRIGGERS set NEXT_FIRE_TIME=PREV_FIRE_TIME where  TRIGGER_NAME='TransactionApprovalJob';");

        Thread.sleep(10000);

        ResultSet cashOutStatus=st.executeQuery("select cash_out_status from remittance_transaction_step_status where transaction_ref_id='"+T2+"';");
        if(cashOutStatus.next()){
            return cashOutStatus.getString(1);
        }


        return  cashOutStatus.getString(1);

    }


    public static String failDueToLostLimitExceeded() throws SQLException, InterruptedException {
        Thread.sleep(3000);
        Statement st = con.createStatement();
//        System.out.println("sql query --> "+"select id from user where email='"+validEmail+"';");
//        ResultSet rs = st.executeQuery("select id from user where email='"+validEmail+"';");
//
//        rs.first();
//        String userId=rs.getString("id");

        ResultSet transactionRefId = st.executeQuery("select transaction_ref_id from remittance_transaction_step_status where user_id=5210;");
        transactionRefId.last();
        T3=transactionRefId.getString(1);
        st.executeUpdate("update remittance_transaction_step_status set initial_fx_rate=2000 where transaction_ref_id='"+T3+"';");

        st.executeUpdate("update QRTZ_TRIGGERS set NEXT_FIRE_TIME=PREV_FIRE_TIME where  TRIGGER_NAME='TransactionApprovalJob';");
        ResultSet cashOutStatus=st.executeQuery("select cash_out_status from remittance_transaction_step_status where transaction_ref_id='"+T3+"';");

        Thread.sleep(10000);

        if(cashOutStatus.next()){
            return cashOutStatus.getString(1);
        }
        return  cashOutStatus.getString(1);

    }



    public static String mockedDataPgProcessing() throws SQLException, InterruptedException {
        Thread.sleep(3000);
        Statement st = con.createStatement();
//        ResultSet rs = st.executeQuery("select id from user where email like '"+validEmail+"';");
//        rs.first();
//        String userId=rs.getString("id");

        ResultSet transactionRefId = st.executeQuery("select transaction_ref_id from remittance_transaction_step_status where user_id=5210;");
        System.out.println("total transactionrefid--> "+transactionRefId);

        transactionRefId.last();
        int getRow=transactionRefId.getRow();
        System.out.println("row vlue"+getRow);
        T4=transactionRefId.getString(1);

        System.out.println("txnRefId-->"+T4);
        //String txnRefId=transactionRefId.getString("transaction_ref_id");

        Statement st1 = con.createStatement();



        st1.executeUpdate("update QRTZ_TRIGGERS set NEXT_FIRE_TIME=PREV_FIRE_TIME where  TRIGGER_NAME='TransactionApprovalJob';");

        Thread.sleep(10000);

        ResultSet cashOutStatus=st1.executeQuery("select cash_out_status from remittance_transaction_step_status where transaction_ref_id='"+T4+"';");
      //  ResultSet cashInStatus=st1.executeQuery("select cash_in_status from remittance_transaction_step_status where transaction_ref_id='"+trxnRefId+"';");



        if(cashOutStatus.next()){

            System.out.println("cashout status of the txn---> "+cashOutStatus.getString(1));
            return cashOutStatus.getString(1);
        }


        */
/*if(cashInStatus.next()){

            System.out.println("cashInStatus status of the txn---> "+cashInStatus.getString(1));
            return cashInStatus.getString(1);
        }*//*


        return  cashOutStatus.getString(1);

    }



    public static String mockedDataInitiatedBookFx() throws SQLException, InterruptedException {
        Thread.sleep(3000);
        Statement st = con.createStatement();
//        ResultSet rs = st.executeQuery("select id from user where email like '"+validEmail+"';");
//        rs.first();
//        String userId=rs.getString("id");

        ResultSet transactionRefId = st.executeQuery("select transaction_ref_id from remittance_transaction_step_status where user_id=5866;");
        System.out.println("total transactionrefid--> "+transactionRefId);

        transactionRefId.last();
        int getRow=transactionRefId.getRow();
        T5=transactionRefId.getString(1);

        System.out.println("txnRefId-->"+T5);
        Statement st1 = con.createStatement();




        st1.executeUpdate("update remittance_transaction_step_status set initial_fx_rate=84 transaction_ref_id='"+T5+"';");

        Thread.sleep(10000);

        st1.executeUpdate("update QRTZ_TRIGGERS set NEXT_FIRE_TIME=PREV_FIRE_TIME where  TRIGGER_NAME='Layer2RetryTransactions';");

        st1.executeUpdate("update QRTZ_TRIGGERS set NEXT_FIRE_TIME=PREV_FIRE_TIME where  TRIGGER_NAME='TransactionApprovalJob';");

        st1.executeUpdate("update QRTZ_TRIGGERS set NEXT_FIRE_TIME=PREV_FIRE_TIME where  TRIGGER_NAME='Layer2RetryTransactions';");

        ResultSet cashOutStatus=st1.executeQuery("select cash_out_status from remittance_transaction_step_status where transaction_ref_id='"+T5+"';");
        //ResultSet cashInStatus=st1.executeQuery("select cash_in_status from remittance_transaction_step_status where transaction_ref_id='"+trxnRefId+"';");



        if(cashOutStatus.next()){

            System.out.println("cashout status of the txn---> "+cashOutStatus.getString(1));

            return cashOutStatus.getString(1);
        }




       */
/* if(cashInStatus.next()){

            System.out.println("cashInStatus status of the txn---> "+cashInStatus.getString(1));


            return cashInStatus.getString(1);
        }*//*


        return  cashOutStatus.getString(1);

    }

    public static boolean cashOutStatusCheck(ExtentTest t) throws SQLException {

        HashMap<Integer,String> m = new HashMap<>();

        Statement st = con.createStatement();

        ResultSet initiatedbookFx=st.executeQuery("select cash_out_status from remittance_transaction_step_status where transaction_ref_id='"+T5+"';");

        String T5=initiatedbookFx.getString(1);
        t.info("cashout status of initiatedbookFx  -- >"+T5);
        m.put(1,T5);

        ResultSet pgProcessing=st.executeQuery("select cash_out_status from remittance_transaction_step_status where transaction_ref_id='"+T4+"';");

        String T4 = pgProcessing.getString(1);
        t.info("cashout status of pgprocessing -- >"+T4);
        m.put(2,T4);
        ResultSet failDueToLostLimitExceeded=st.executeQuery("select cash_out_status from remittance_transaction_step_status where transaction_ref_id='"+T3+"';");

        String T3 = failDueToLostLimitExceeded.getString(1);
        t.info("cashout status of fail due to limit --> "+T3);
        m.put(3,T3);
        ResultSet mockingUnableToBookFx=st.executeQuery("select cash_out_status from remittance_transaction_step_status where transaction_ref_id='"+T2+"';");

        String T2 = mockingUnableToBookFx.getString(1);
        t.info("cashout status of unable to book fx -- >"+T2);
        m.put(2,T2);
        ResultSet mockedDataFailedDueToIncorrectValue=st.executeQuery("select cash_out_status from remittance_transaction_step_status where transaction_ref_id='"+T1+"';");

        String T1 = mockedDataFailedDueToIncorrectValue.getString(1);
        t.info("cashout status of fail due to incorrect value -- >"+ T1);
        m.put(1,T1);

        System.out.println("value of map ---> "+ m);

        for(int i : m.keySet())
        {
            if(m.get(i) == null )
                return false;
        }

        return true;
    }


    public static void txnApprovalJobFirstRun(ExtentTest t) throws SQLException, InterruptedException {

        Statement st = con.createStatement();

        st.executeUpdate("update QRTZ_TRIGGERS set NEXT_FIRE_TIME=PREV_FIRE_TIME where  TRIGGER_NAME='TransactionApprovalJob';");


        st.executeUpdate("update QRTZ_TRIGGERS set NEXT_FIRE_TIME=PREV_FIRE_TIME where  TRIGGER_NAME='AchTransactionProcessJob';");

        Thread.sleep(15000);

        ResultSet rs = st.executeQuery("select id from user where email like '"+validEmail+"';");
        rs.first();
        String userId=rs.getString("id");

        ResultSet transactionRefId = st.executeQuery("select transaction_ref_id from remittance_transaction_step_status where user_id="+userId+";");
        System.out.println("total transactionrefid--> "+transactionRefId);

        transactionRefId.last();
        int getRow=transactionRefId.getRow();
        T5=transactionRefId.getString(1);

        ResultSet cashOutStatus=st.executeQuery("select cash_out_status from remittance_transaction_step_status where transaction_ref_id='"+T5+"';");


        if(cashOutStatus.next()) {
            System.out.println("cashout status of the txn---> " + cashOutStatus.getString(1));
            t.info("cashout status of the txn---> " + cashOutStatus.getString(1));
        }

    }

    public static void achTransactionJobFirst(ExtentTest t) throws SQLException, InterruptedException {
        Statement st = con.createStatement();

        st.executeUpdate("update QRTZ_TRIGGERS set NEXT_FIRE_TIME=PREV_FIRE_TIME where  TRIGGER_NAME='AchTransactionProcessJob';");

        st.executeUpdate("update QRTZ_TRIGGERS set NEXT_FIRE_TIME=PREV_FIRE_TIME where  TRIGGER_NAME='TransactionApprovalJob';");

        Thread.sleep(15000);

        ResultSet rs = st.executeQuery("select id from user where email like '"+validEmail+"';");
        rs.first();
        String userId=rs.getString("id");

        ResultSet transactionRefId = st.executeQuery("select transaction_ref_id from remittance_transaction_step_status where user_id="+userId+";");
        System.out.println("total transactionrefid--> "+transactionRefId);

        transactionRefId.last();
        int getRow=transactionRefId.getRow();
        T5=transactionRefId.getString(1);

        ResultSet cashOutStatus=st.executeQuery("select cash_out_status from remittance_transaction_step_status where transaction_ref_id='"+T5+"';");


        if(cashOutStatus.next()) {
            System.out.println("cashout status of the txn---> " + cashOutStatus.getString(1));
            t.info("cashout status of the txn---> " + cashOutStatus.getString(1));
        }


    }



    public static String mockTheTransactionToConfirmByProvider() throws SQLException, InterruptedException {
        Thread.sleep(3000);
        Statement st = con.createStatement();

        ResultSet transactionRefId = st.executeQuery("select transaction_ref_id from remittance_transaction_step_status where user_id=5866;");
        System.out.println("total transactionrefid--> "+transactionRefId);

        transactionRefId.last();
        int getRow=transactionRefId.getRow();
        T5=transactionRefId.getString(1);

        System.out.println("txnRefId-->"+T5);
        Statement st1 = con.createStatement();


        st1.executeUpdate("update remittance_transaction set status ='FAILED' where remittance_transaction_strategy = 'NORMAL_INITIATE' and remittance_partner = 'NIUM' and status <> 'FAILED'");
        st1.executeUpdate("update remittance_transaction_step_status set cash_in_status='CONFIRMED_BY_PROVIDER' where transaction_ref_id='"+T5+"';");
        st1.executeUpdate("update remittance_transaction set status='CONFIRMED_BY_PROVIDER' where transaction_ref_id='"+T5+"';");


        Thread.sleep(10000);


        ResultSet cashInStatus=st1.executeQuery("select cash_in_status from remittance_transaction_step_status where transaction_ref_id='"+T5+"';");
        //ResultSet cashInStatus=st1.executeQuery("select cash_in_status from remittance_transaction_step_status where transaction_ref_id='"+trxnRefId+"';");

        if(cashInStatus.next()){

            System.out.println("cashin status of the txn---> "+cashInStatus.getString(1));

            return cashInStatus.getString(1);
        }


       */
/* if(cashInStatus.next()){

            System.out.println("cashInStatus status of the txn---> "+cashInStatus.getString(1));


            return cashInStatus.getString(1);
        }*//*


        return  cashInStatus.getString(1);

    }

    public static String dateAndTime() {


        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
        String time = dtf.format(now);

        char t[] = time.toCharArray();
        t[10] = 'T';
        return String.valueOf(t);

    }
       public static void initiateFundingWebhook() throws JSchException {

        String jumpserverHost = "3.208.52.181";
        String jumpserverUsername = "vikas.kumar";

        Random r = new Random();
        int num = r.nextInt(90) + 10;

         String command1 = "curl --location --request POST 'http://10.0.150.58:9002/bank/webhooks/nium/v1' --header 'Content-Type: application/json' --header 'x-api-key: 5XFttn3S04yArFZvexvtcw==' --data-raw '{ \"client_id\": \"308494Sy4c$i6ai982880Syx45$ia6s\", \"account_number\": \"335750125146\",  \"currency_code\": \"USD\",\"amount\": 1000,\"status\": \"SUCCESS\",\"funding_id\": \"PREPF107251"+num+"\",\"gl_reference_number\": \"1629183106811715\", \"event\": \"FUNDING_UPDATE\",\"payment_id\" : \"abcd\", \"remark\": \"fdg  Bank of Lithuania - LT593590010000000000 - EUR - Lithuania\",\"timestamp\": \""+dateAndTime()+"Z\"}'";


        JSch jsch = new JSch();
        String HOME = "C:\\Users\\vikas.kumar5";
        System.out.println("======="+HOME);
        String knownHostsFileName = Paths.get(HOME, ".ssh", "known_hosts").toString();
        String identity = Paths.get(HOME, ".ssh", "id_rsa").toString();
        System.out.println("identity name"+identity);



        System.out.println("knownHostsFileName: " + knownHostsFileName);// print file name

        if (knownHostsFileName != null && new File(knownHostsFileName).exists()) {
            try {
                jsch.addIdentity(identity,"Vikas@9910");
                System.out.println("iddentity file loaded successfully");
            } catch (JSchException e) {
                e.printStackTrace();
            }
            System.out.println("KnownHostsFile added");
        }

        // Connect to SSH jump server (this does not show an authentication code)
        Session session = null;
        try {
            session = jsch.getSession(jumpserverUsername, jumpserverHost,22);
        } catch (JSchException e) {
            e.printStackTrace();
        }
        java.util.Properties config = new java.util.Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config);
        System.out.println("connecting..");
        try {
            session.connect();
        } catch (JSchException e) {
            System.out.println("exception is ====="+e);
//            e.printStackTrace();
        }catch (Exception e){
            System.out.println("exception is 2 ====="+e);
        }
        System.out.println("connected");

//        int forwardedPort = 0;
//        Session sessionB = null;
//        try {
//           String ec2Host = "10.0.150.58";
//           String jumpUser = "vikas.kumar";
//           String jumpHost = "3.208.52.181";
//           int jumpPort = 22;
//
//            //ProxySOCKS5 proxy = new ProxySOCKS5(jumpHost, jumpPort);
//            sessionB = jsch.getSession("vikas.kumar","10.0.150.58", 9002);
//            sessionB.setPassword("Vikas@9910");
//
//            sessionB.setProxy(proxy);
//
//            sessionB.setConfig("StrictHostKeyChecking", "no");
//
//           // forwardedPort = session.setPortForwardingL(8000, "10.0.150.58",22);
//
////           String proxy = "ssh -W " + ec2Host + ":9002 " + jumpUser + "@" + jumpHost;
//
//
//     //    sessionB.setProxy(new ProxyHTTP(proxy));
//
//            System.out.println("try test block");
//            System.out.println("forwarded port --->"+forwardedPort);
//
//
//            sessionB.connect();
//        } catch (JSchException e) {
//            e.printStackTrace();
//        }


        try {

            ChannelExec channel = (ChannelExec)session.openChannel("exec");
           ((ChannelExec) channel).setCommand(command1);
            channel.setInputStream(null);
            ((ChannelExec) channel).setErrStream(System.err);
            InputStream in=channel.getInputStream();
            channel.connect();
            System.out.println("Nium funding webhook processed successfully.....................");

            byte[] tmp=new byte[1024];

            while(true){
                while(in.available()>0){
                    int i=in.read(tmp, 0, 1024);
                    if(i<0)break;
                    System.out.print(new String(tmp, 0, i));
                }
                if(channel.isClosed()){
                    System.out.println("exit-status: "+channel.getExitStatus());
                    break;
                }
                try{Thread.sleep(1000);}catch(Exception ee){}
            }
            channel.disconnect();
            session.disconnect();
           // sessionB.disconnect();

            System.out.println("Webhook process done...............");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }


    }




    public static String markingTxnToPaid() throws JSchException, SQLException, InterruptedException {

        String jumpserverHost = "3.208.52.181";
        String jumpserverUsername = "vikas.kumar";

        Random r = new Random();
        int num = r.nextInt(90) + 10;

        String command1 = "curl --location --request POST 'http://10.0.150.58:9002/bank/webhooks/nium/v1' --header 'Content-Type: application/json' --header 'x-api-key: 5XFttn3S04yArFZvexvtcw==' --data-raw '{ \"reference_number\": \"1625203888\",\"payment_id\": \""+fetchingPartnerTransactionId()+"\",\"event\": \"TRANSACTION_STATUS_CHANGE\",\"status\": \"PAID\",\"timestamp\": \""+dateAndTime()+"Z\"}'";

        JSch jsch = new JSch();
        String HOME = "C:\\Users\\vikas.kumar5";
        System.out.println("======="+HOME);
        String knownHostsFileName = Paths.get(HOME, ".ssh", "known_hosts").toString();
        String identity = Paths.get(HOME, ".ssh", "id_rsa").toString();
        System.out.println("identity name"+identity);



        System.out.println("knownHostsFileName: " + knownHostsFileName);// print file name

        if (knownHostsFileName != null && new File(knownHostsFileName).exists()) {
            try {
                jsch.addIdentity(identity,"Vikas@9910");
                System.out.println("iddentity file loaded successfully");
            } catch (JSchException e) {
                e.printStackTrace();
            }
            System.out.println("KnownHostsFile added");
        }

        // Connect to SSH jump server (this does not show an authentication code)
        Session session = null;
        try {
            session = jsch.getSession(jumpserverUsername, jumpserverHost,22);
        } catch (JSchException e) {
            e.printStackTrace();
        }
        java.util.Properties config = new java.util.Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config);
        System.out.println("connecting..");
        try {
            session.connect();
        } catch (JSchException e) {
            System.out.println("exception is ====="+e);
//            e.printStackTrace();
        }catch (Exception e){
            System.out.println("exception is 2 ====="+e);
        }
        System.out.println("connected");

//        int forwardedPort = 0;
//        Session sessionB = null;
//        try {
//           String ec2Host = "10.0.150.58";
//           String jumpUser = "vikas.kumar";
//           String jumpHost = "3.208.52.181";
//           int jumpPort = 22;
//
//            //ProxySOCKS5 proxy = new ProxySOCKS5(jumpHost, jumpPort);
//            sessionB = jsch.getSession("vikas.kumar","10.0.150.58", 9002);
//            sessionB.setPassword("Vikas@9910");
//
//            sessionB.setProxy(proxy);
//
//            sessionB.setConfig("StrictHostKeyChecking", "no");
//
//           // forwardedPort = session.setPortForwardingL(8000, "10.0.150.58",22);
//
////           String proxy = "ssh -W " + ec2Host + ":9002 " + jumpUser + "@" + jumpHost;
//
//
//     //    sessionB.setProxy(new ProxyHTTP(proxy));
//
//            System.out.println("try test block");
//            System.out.println("forwarded port --->"+forwardedPort);
//
//
//            sessionB.connect();
//        } catch (JSchException e) {
//            e.printStackTrace();
//        }


        try {

            ChannelExec channel = (ChannelExec)session.openChannel("exec");
            ((ChannelExec) channel).setCommand(command1);
            channel.setInputStream(null);
            ((ChannelExec) channel).setErrStream(System.err);
            InputStream in=channel.getInputStream();
            channel.connect();
            System.out.println("Nium funding webhook processed successfully.....................");

            byte[] tmp=new byte[1024];

            while(true){
                while(in.available()>0){
                    int i=in.read(tmp, 0, 1024);
                    if(i<0)break;
                    System.out.print(new String(tmp, 0, i));
                }
                if(channel.isClosed()){
                    System.out.println("exit-status: "+channel.getExitStatus());
                    break;
                }
                try{Thread.sleep(1000);}catch(Exception ee){}
            }
            channel.disconnect();
            session.disconnect();
            // sessionB.disconnect();

            System.out.println("Webhook process done...............");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        Thread.sleep(10000);
        Statement st = con.createStatement();

        ResultSet transactionRefId = st.executeQuery("select transaction_ref_id from remittance_transaction_step_status where user_id=5866;");
        System.out.println("total transactionrefid--> "+transactionRefId);

        transactionRefId.last();
        int getRow=transactionRefId.getRow();
        T5=transactionRefId.getString(1);

        Statement st1 = con.createStatement();

        ResultSet cashOutStatus = st1.executeQuery("select cash_out_status from remittance_transaction_step_status where transaction_ref_id='"+T5+"';");

        if(cashOutStatus.next())
        {
            System.out.println("cashout status of transaction from RTSS table is ---->" + cashOutStatus.getString(1));
            return cashOutStatus.getString(1);
        }

        return null;


    }

    public static String fetchingPartnerTransactionId() throws InterruptedException, SQLException {
        Thread.sleep(15000);
        Statement st = con.createStatement();

        ResultSet transactionRefId = st.executeQuery("select transaction_ref_id from remittance_transaction_step_status where user_id=5866;");
        System.out.println("total transactionrefid--> "+transactionRefId);

        transactionRefId.last();
        int getRow=transactionRefId.getRow();
        T5=transactionRefId.getString(1);

        Statement st1 = con.createStatement();

        ResultSet partnerTransactionId = st1.executeQuery("select partner_transaction_id from remittance_transaction_step_status where transaction_ref_id='"+T5+"';");

        if(partnerTransactionId.next())
        {
            System.out.println("partner transaction id from RTSS table is ---->" + partnerTransactionId.getString(1));
            return partnerTransactionId.getString(1);
        }
return null;
    }

// prefunding webhook mocking
    public static String mockThePrefundingTransaction() throws SQLException, InterruptedException {
        Thread.sleep(3000);
        Statement st = con.createStatement();

        ResultSet transactionRefId = st.executeQuery("select transaction_ref_id from remittance_transaction_step_status where user_id=6005;");
        System.out.println("total transactionrefid--> "+transactionRefId);

        transactionRefId.last();
        int getRow=transactionRefId.getRow();
        T5=transactionRefId.getString(1);

        System.out.println("txnRefId-->"+T5);
        Statement st1 = con.createStatement();


        st1.executeUpdate("update remittance_transaction set status ='FAILED' where remittance_transaction_strategy = 'BOOK_FX_STRATEGY' and remittance_partner = 'NIUM' and status <> 'FAILED' ;");
        st1.executeUpdate("update remittance_transaction_step_status set cash_in_status='WAITING_FOR_PROVIDER_CONFIRMATION' where transaction_ref_id='"+T5+"';");
        st1.executeUpdate("update remittance_transaction set status='WAITING_FOR_CASHOUT_PROCESSING' where transaction_ref_id='"+T5+"';");
        st1.executeUpdate("update remittance_transaction_cash_in set ach_confirmation_source = 'JOB' where remittance_transaction_ref_id ='"+T5+"';");

        //  update remittance_transaction set status ='FAILED' where remittance_transaction_strategy = 'NORMAL_INITIATE' and remittance_partner = 'NIUM' and status <> 'FAILED';


        Thread.sleep(10000);


        ResultSet cashInStatus=st1.executeQuery("select cash_in_status from remittance_transaction_step_status where transaction_ref_id='"+T5+"';");
        //ResultSet cashInStatus=st1.executeQuery("select cash_in_status from remittance_transaction_step_status where transaction_ref_id='"+trxnRefId+"';");

        if(cashInStatus.next()){

            System.out.println("cashin status of the txn---> "+cashInStatus.getString(1));

            return cashInStatus.getString(1);
        }


       */
/* if(cashInStatus.next()){

            System.out.println("cashInStatus status of the txn---> "+cashInStatus.getString(1));


            return cashInStatus.getString(1);
        }*//*


        return  cashInStatus.getString(1);

    }


    public static String initiatePrefundingWebhook() throws JSchException, SQLException, InterruptedException {

        String jumpserverHost = "3.208.52.181";
        String jumpserverUsername = "vikas.kumar";

        Random r = new Random();
        int num = r.nextInt(90) + 10;

        String command1 = "curl --location --request POST 'http://10.0.150.58:9002/bank/webhooks/nium/v1' --header 'Content-Type: application/json' --header 'x-api-key: 5XFttn3S04yArFZvexvtcw==' --data-raw '{\"client_id\": \"308494Sy4c$i6ai982880Syx45$ia6s\",\"account_number\": \"335750128617\",\"currency_code\": \"USD\",\"amount\": 1000, \"status\": \"SUCCESS\",\"funding_id\": \"PREPF100676"+num+"\",\"gl_reference_number\": \"1629183106811715\", \"event\": \"FUNDING_UPDATE\", \"payment_id\" : \"abcd\",\"remark\": \"fdg  Bank of Lithuania - LT593590010000000000 - EUR - Lithuania\", \"timestamp\": \""+dateAndTime()+"Z\"}'";

        JSch jsch = new JSch();
        String HOME = "C:\\Users\\vikas.kumar5";
        System.out.println("======="+HOME);
        String knownHostsFileName = Paths.get(HOME, ".ssh", "known_hosts").toString();
        String identity = Paths.get(HOME, ".ssh", "id_rsa").toString();
        System.out.println("identity name"+identity);



        System.out.println("knownHostsFileName: " + knownHostsFileName);// print file name

        if (knownHostsFileName != null && new File(knownHostsFileName).exists()) {
            try {
                jsch.addIdentity(identity,"Vikas@9910");
                System.out.println("iddentity file loaded successfully");
            } catch (JSchException e) {
                e.printStackTrace();
            }
            System.out.println("KnownHostsFile added");
        }

        // Connect to SSH jump server (this does not show an authentication code)
        Session session = null;
        try {
            session = jsch.getSession(jumpserverUsername, jumpserverHost,22);
        } catch (JSchException e) {
            e.printStackTrace();
        }
        java.util.Properties config = new java.util.Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config);
        System.out.println("connecting..");
        try {
            session.connect();
        } catch (JSchException e) {
            System.out.println("exception is ====="+e);
//            e.printStackTrace();
        }catch (Exception e){
            System.out.println("exception is 2 ====="+e);
        }
        System.out.println("connected");




        try {

            ChannelExec channel = (ChannelExec)session.openChannel("exec");
            ((ChannelExec) channel).setCommand(command1);
            channel.setInputStream(null);
            ((ChannelExec) channel).setErrStream(System.err);
            InputStream in=channel.getInputStream();
            channel.connect();
            System.out.println("Nium prefunding webhook processed successfully.....................");

            byte[] tmp=new byte[1024];

            while(true){
                while(in.available()>0){
                    int i=in.read(tmp, 0, 1024);
                    if(i<0)break;
                    System.out.print(new String(tmp, 0, i));
                }
                if(channel.isClosed()){
                    System.out.println("exit-status: "+channel.getExitStatus());
                    break;
                }
                try{Thread.sleep(1000);}catch(Exception ee){}
            }
            channel.disconnect();
            session.disconnect();
            // sessionB.disconnect();

            System.out.println("Webhook process done...............");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

      Thread.sleep(10000);


        Statement st1 = con.createStatement();


        ResultSet bookFxId = st1.executeQuery("select booking_fx_confirmation_id from remittance_transaction_step_status where transaction_ref_id='"+T5+"';");

        if(bookFxId.next())
        {
            System.out.println("Bookfx id return from RTSS table is ---->" + bookFxId.getString(1));
            Assert.assertTrue(bookFxId.getString(1) != null);
        }

        ResultSet cashOutStatus = st1.executeQuery("select cash_out_status from remittance_transaction_step_status where transaction_ref_id='"+T5+"';");

        if(cashOutStatus.next())
        {
            System.out.println("cahsout status after firing prefunding webhook ---->" + cashOutStatus.getString(1));
            return cashOutStatus.getString(1);
        }
        return cashOutStatus.getString(1);
    }

}
*/
