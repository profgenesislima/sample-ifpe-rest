     INSERT INTO usuario(nome, email, senha) VALUES ('teste', 'teste@teste.com', '$2a$10$jFSLHC9XHcMY7dqtutV49OgN5Pus8MLHLX2vPwBWJV9CoAa6qWJE.');

      
      INSERT INTO categoria(nome) VALUES ('Brinquedo');
      INSERT INTO categoria(nome) VALUES ('Eletrodomesticos');
      
      INSERT INTO produto(nome,preco,categoria_id) VALUES ('LEGO', 200.00, 1);
      INSERT INTO produto(nome,preco,categoria_id) VALUES ('Hot Wheels', 10.00, 1);
      INSERT INTO produto(nome,preco,categoria_id) VALUES ('Funko Pop!', 100.00, 1);
      
      INSERT INTO produto(nome, preco, categoria_id) VALUES ('Fritadeira Elétrica', 400.00, 2);
      INSERT INTO produto(nome, preco, categoria_id) VALUES ('Forno Microondas', 400.00, 2);
      INSERT INTO produto(nome, preco, categoria_id) VALUES ('Liquidificador', 120.00, 2);
      