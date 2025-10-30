function CompanyMaskInit() {
    if (document.querySelector("#cnpj")) {
        new Cleave("#cnpj", {
            delimiters: [".", ".", "/", "-"],
            blocks: [2, 3, 3, 4, 2],
            numericOnly: true // ✅ impede digitar qualquer coisa que não seja número
        });
    }

    if (document.querySelector("#cep")) {
        new Cleave("#cep", {
            delimiters: ["-"],
            blocks: [5, 3],
            numericOnly: true // ✅ impede letras, só números
        });
    }
}

/* function CompanyMaskInit(params) {
    var cleaveCNPJ, cleaveCEP;
    document.querySelector("#cnpj") && (cleaveDelimiters = new Cleave("#cnpj", {
        delimiters: [".", ".", "/", "-"],
        blocks: [2, 3, 3, 4, 2],
        uppercase: !0
    })),
        document.querySelector("#cep") && (cleaveDelimiters = new Cleave("#cep", {
            delimiters: ["-"],
            blocks: [5, 3],
            uppercase: !0
        }));
} */






