package br.com.address.view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

public class TreeViewController implements Initializable{
	
	@FXML
	TreeView <String> treeView;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		TreeItem<String> root = new TreeItem<>("Portfólio");
		
		TreeItem<String> nodeA = new TreeItem<>("Linha Apolo");
		TreeItem<String> nodeB = new TreeItem<>("Linha Cronos");
		TreeItem<String> nodeC = new TreeItem<>("Linha Ares");
		TreeItem<String> nodeD = new TreeItem<>("Linha Zeus");
		root.getChildren().addAll(nodeA,nodeB,nodeC,nodeD);
		
		TreeItem<String> nodeA1 = new TreeItem<>("Apolo 6031");
		nodeA.getChildren().add(nodeA1);
		
		TreeItem<String> nodeB1 = new TreeItem<>("Cronos 6001-A");
		TreeItem<String> nodeB2 = new TreeItem<>("Cronos 6021-A");
		TreeItem<String> nodeB3 = new TreeItem<>("Cronos 6021L");
		TreeItem<String> nodeB4 = new TreeItem<>("Cronos 6003");
		TreeItem<String> nodeB5 = new TreeItem<>("Cronos 7023");
		TreeItem<String> nodeB6 = new TreeItem<>("Cronos 7023L");
		TreeItem<String> nodeB7 = new TreeItem<>("Cronos 7023 2,5");
		nodeB.getChildren().addAll(nodeB1,nodeB2,nodeB3,nodeB4,nodeB5,nodeB6,nodeB7);
		
		TreeItem<String> nodeC1 = new TreeItem<>("Ares 7021");
		TreeItem<String> nodeC2 = new TreeItem<>("Ares 7031");
		TreeItem<String> nodeC3 = new TreeItem<>("Ares 7023");
		TreeItem<String> nodeC4 = new TreeItem<>("Ares 8023");
		TreeItem<String> nodeC5 = new TreeItem<>("Ares 8023 15");
		TreeItem<String> nodeC6 = new TreeItem<>("Ares 8023 200");
		nodeC.getChildren().addAll(nodeC1,nodeC2,nodeC3,nodeC4,nodeC5,nodeC6);
		
		TreeItem<String> nodeD1 = new TreeItem<>("Zeus 8021");
		TreeItem<String> nodeD2 = new TreeItem<>("Zeus 8031");
		TreeItem<String> nodeD3 = new TreeItem<>("Zeus 8023");
		nodeD.getChildren().addAll(nodeD1,nodeD2,nodeD3);
		
		treeView.setRoot(root);
		
	}

}
