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

window.ShowToast = (title, message, type = 'primary', redirectUrl) => {

    // Cria (ou reaproveita) o container centralizado no topo
    const toastContainer = document.getElementById('toast-container') || (() => {
        const div = document.createElement('div');
        div.id = 'toast-container';
        div.className = 'toast-container position-fixed top-0 start-50 translate-middle-x p-3';
        div.style.zIndex = 2000;
        document.body.appendChild(div);
        return div;
    })();

    // Define ícones SVG baseados no tipo do toast
    const icons = {
        success: `<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="currentColor" class="bi bi-check-circle-fill me-2 text-success" viewBox="0 0 16 16">
                    <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM6.97 10.97l5.385-5.385-1.415-1.414L6.97 8.142 5.06 6.232l-1.415 1.415 3.324 3.323z"/>
                  </svg>`,
        danger: `<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="currentColor" class="bi bi-x-circle-fill me-2 text-danger" viewBox="0 0 16 16">
                    <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM5.354 4.646l.353.354L8 7.293l2.293-2.293.353-.354a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 1 1 .708-.708z"/>
                  </svg>`,
        warning: `<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="currentColor" class="bi bi-exclamation-triangle-fill me-2 text-warning" viewBox="0 0 16 16">
                    <path d="M8.982 1.566a1.13 1.13 0 0 0-1.964 0L.165 13.233c-.457.778.091 1.767.982 1.767h13.706c.89 0 1.438-.99.982-1.767L8.982 1.566zM8 5c.535 0 .954.462.9.995l-.35 3.507a.552.552 0 0 1-1.1 0L7.1 5.995A.905.905 0 0 1 8 5zm.002 6a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"/>
                  </svg>`,
        info: `<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="currentColor" class="bi bi-info-circle-fill me-2 text-info" viewBox="0 0 16 16">
                    <path d="M8 0a8 8 0 1 0 0 16A8 8 0 0 0 8 0zM8.93 4.588a.9.9 0 1 1-1.86 0 .9.9 0 0 1 1.86 0zM6.002 7h1v5h2V7h1V6H6v1z"/>
                  </svg>`
    };

    // Cria o toast com estilo visual
    const toast = document.createElement('div');
    toast.className = `toast align-items-center text-bg-${type} border-0 shadow show`;
    toast.role = 'alert';
    toast.style.minWidth = '240px';
    toast.style.animation = 'fadeSlideDown 0.4s ease-out';
    toast.innerHTML = `
        <div class="d-flex align-items-center px-2 py-1">
            <div class="toast-body d-flex align-items-center">
                ${icons[type] || icons.info}
                <div>
                    <strong>${title}</strong><br>${message}
                </div>
            </div>
            <button type="button" class="btn-close btn-close-white me-2 m-auto" 
                    data-bs-dismiss="toast" aria-label="Close"></button>
        </div>
    `;

    toastContainer.appendChild(toast);

    const bsToast = new bootstrap.Toast(toast);
    bsToast.show();

    // Fecha automaticamente após 4 segundos
    const autoClose = setTimeout(() => {
        bsToast.hide();
    }, 2000);

    // Quando o usuário fecha manualmente
    toast.addEventListener('hidden.bs.toast', () => {
        clearTimeout(autoClose);
        toast.remove();
        if (redirectUrl) {
            window.location.href = redirectUrl;
        }
    });
};

// Animação para a entrada do toast
const style = document.createElement('style');
style.textContent = `
@keyframes fadeSlideDown {
  from { opacity: 0; transform: translateY(-20px) scale(0.95); }
  to   { opacity: 1; transform: translateY(0) scale(1); }
}
`;
document.head.appendChild(style);







