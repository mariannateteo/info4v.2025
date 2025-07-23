CREATE TABLE PlanoPagamento (
    id INT PRIMARY KEY AUTO_INCREMENT,
    aluno_id INT NOT NULL,
    nome_plano VARCHAR(100) NOT NULL,
    valor DECIMAL(10,2) NOT NULL,
    duracao_meses INT NOT NULL,
    data_inicio DATE NOT NULL,
    data_fim DATE NOT NULL,
    data_pagamento DATE NOT NULL,
    metodo_pagamento ENUM('CARTAO', 'PIX', 'BOLETO', 'DINHEIRO') NOT NULL,
    status_pagamento ENUM('PAGO', 'PENDENTE', 'ATRASADO') DEFAULT 'PAGO',
    FOREIGN KEY (aluno_id) REFERENCES Aluno(id)
);
