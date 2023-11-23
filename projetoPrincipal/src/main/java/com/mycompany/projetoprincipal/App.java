package com.mycompany.projetoprincipal;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {
    private TableView<Cidadao> tabelaCidadao;
    private TextField campoNome;
    private TextField campoEmail;
    private ObservableList<Cidadao> listaCidadao;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("SRP - Sistema de Reclamação Popular");

        tabelaCidadao = new TableView<>();
        listaCidadao = FXCollections.observableArrayList();

        TableColumn<Cidadao, Integer> colunaId = new TableColumn<>("ID");
        colunaId.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());

        TableColumn<Cidadao, String> colunaNome = new TableColumn<>("Nome");
        colunaNome.setCellValueFactory(cellData -> cellData.getValue().nomeProperty());

        TableColumn<Cidadao, String> colunaEmail = new TableColumn<>("Email");
        colunaEmail.setCellValueFactory(cellData -> cellData.getValue().emailProperty());

        tabelaCidadao.getColumns().add(colunaId);
        tabelaCidadao.getColumns().add(colunaNome);
        tabelaCidadao.getColumns().add(colunaEmail);

        tabelaCidadao.setItems(listaCidadao);

        Button btnAdicionar = new Button("Adicionar");
        btnAdicionar.setOnAction(event -> adicionarCidadao());

        Button btnEditar = new Button("Editar");
        btnEditar.setOnAction(event -> editarCidadao());

        Button btnRemover = new Button("Remover");
        btnRemover.setOnAction(event -> removerCidadao());

        campoNome = new TextField();
        campoNome.setPromptText("Nome");

        campoEmail = new TextField();
        campoEmail.setPromptText("Email");

        VBox vbox = new VBox();
        vbox.getChildren().addAll(tabelaCidadao, campoNome, campoEmail, btnAdicionar, btnEditar, btnRemover);

        Scene scene = new Scene(vbox);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void adicionarCidadao() {
        String nome = campoNome.getText();
        String email = campoEmail.getText();

        if (!nome.isEmpty() && !email.isEmpty()) {
            Cidadao cidadao = new Cidadao(listaCidadao.size() + 1, nome, email);
            listaCidadao.add(cidadao);

            campoNome.clear();
            campoEmail.clear();
        }
    }

    private void editarCidadao() {
        Cidadao cidadaoSelecionado = tabelaCidadao.getSelectionModel().getSelectedItem();

        if (cidadaoSelecionado != null) {
            String novoNome = campoNome.getText();
            String novoEmail = campoEmail.getText();

            if (!novoNome.isEmpty() && !novoEmail.isEmpty()) {
                cidadaoSelecionado.setNome(novoNome);
                cidadaoSelecionado.setEmail(novoEmail);

                tabelaCidadao.refresh();
                campoNome.clear();
                campoEmail.clear();
            }
        }
    }

    private void removerCidadao() {
        Cidadao cidadaoSelecionado = tabelaCidadao.getSelectionModel().getSelectedItem();

        if (cidadaoSelecionado != null) {
            listaCidadao.remove(cidadaoSelecionado);
            tabelaCidadao.refresh();
            campoNome.clear();
            campoEmail.clear();
        }
    }
}
