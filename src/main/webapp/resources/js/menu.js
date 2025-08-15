(function(){
  const btn  = document.querySelector('.nav__toggle');
  const menu = document.getElementById('menu-list');
  if (!btn || !menu) return;

  // En móviles: aseguramos cerrado en carga
  const mq = window.matchMedia('(max-width: 768px)');
  function ensureState() {
    if (mq.matches) {           // móvil/tablet
      menu.classList.remove('show');
      btn.setAttribute('aria-expanded', 'false');
    } else {                    // desktop
      // el CSS ya lo muestra; el botón se oculta
      menu.classList.remove('show');
      btn.setAttribute('aria-expanded', 'false');
    }
  }
  ensureState();
  mq.addEventListener?.('change', ensureState);

  btn.addEventListener('click', () => {
    const expanded = btn.getAttribute('aria-expanded') === 'true';
    btn.setAttribute('aria-expanded', String(!expanded));
    menu.classList.toggle('show');
  });
})();