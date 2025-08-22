(function () {
  // Ejecuta cuando el DOM esté listo (o carga el script con defer)
  if (document.readyState === 'loading') {
    document.addEventListener('DOMContentLoaded', init);
  } else {
    init();
  }

  function init() {
    var btn  = document.querySelector('.nav__toggle');
    var menu = document.getElementById('menu-list');
    if (!btn || !menu) return;

    var mq = (typeof window.matchMedia === 'function')
      ? window.matchMedia('(max-width: 768px)')
      : null;

    function ensureState() {
      if (!mq) return; // evita acceder a mq.matches si no existe
      // estado inicial: cerrado
      menu.classList.remove('show');
      btn.setAttribute('aria-expanded', 'false');
    }

    // << la línea que marcaba error, ahora sigue siendo válida >>
    ensureState();

    // sin optional chaining; con fallback antiguo
    if (mq) {
      if (typeof mq.addEventListener === 'function') {
        mq.addEventListener('change', ensureState);
      } else if (typeof mq.addListener === 'function') {
        mq.addListener(ensureState);
      }
    }

    btn.addEventListener('click', function () {
      var expanded = btn.getAttribute('aria-expanded') === 'true';
      btn.setAttribute('aria-expanded', String(!expanded));
      menu.classList.toggle('show');
    });
  }
})();
