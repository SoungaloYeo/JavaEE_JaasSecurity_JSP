///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package DaoTest;
//
//import com.objis.proxibanque.dao.impl.ClientDao;
//import com.objis.proxibanque.dao.impl.ConnectionTest;
//import com.objis.proxibanque.domaine.Client;
//import java.util.List;
//import junit.framework.Assert;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
///**
// *
// * @author yeo sglo
// */
//public class ClientDaoTest {
//
//    public ClientDao clientDao;
//    Client client;
//    Client clientUpdate;
//
//    @Before
//    public void setUp() throws Exception {
//        //clientDaoMock = Mockito.mock(ClientDao.class);
//        clientDao = new ClientDao(ConnectionTest.getInstence());
//        client = new Client();
//        client.setCodeClient("PB-CLI-00035");
//        client.setNom("TEST");
//        client.setPrenoms("TEST TEST");
//        client.setEmail("test@test");
//        client.setAdresse("BP14 ABEN 05");
//        client.setCodeGestionnaire("PB-GEST-003");
//
//        clientUpdate = new Client();
//        clientUpdate.setCodeClient("PB-CLI-0031");
//        clientUpdate.setNom("TEST");
//        clientUpdate.setPrenoms("TEST MODIF");
//        clientUpdate.setEmail("test@test");
//        clientUpdate.setAdresse("BP14 ABEN 05");
//        clientUpdate.setCodeGestionnaire("PB-GEST-002");
//    }
//
//    @Test
//    public void enregUnClientTest() {
//        Assert.assertTrue("enregistrement effectué avec succes ", clientDao.create(client));
//    }
//    
//    @Test
//    public void modifUnClientTest() {
//        Assert.assertTrue("enregistrement effectué avec succes ", clientDao.update(clientUpdate));
//    }
//}
