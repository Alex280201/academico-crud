// Languages: English (default) and Spanish. Used by students.html, pokemon.html and detail.html.
const TEXTS = {
  en: {
    other: "Español", switchLanguage: "Switch language", navAria: "Main menu", menu: "Open menu",
    appSub: "Student management", navStudents: "Students", navApi: "Page 2 (public API)",
    retry: "Retry", back: "Back", viewAria: "View details of {name}",
    p1Title: "Students · Academico", p1Search: "Search by name, ID number or email",
    p1SearchAria: "Search students", p1Live: "Searches as you type", p1New: "+ New student",
    p1Count: "Showing {n} of {total}", p1ListAria: "Student list", loading: "Loading students…",
    noneYet: "No students yet. Use the New student button to add some.",
    noMatch: "No students match your search.",
    connErr: "Could not reach the server. Make sure the app is running and that you opened this page from localhost:8080.",
    idLabel: "Student ID {id}", fIdNumber: "National ID", fName: "Full name", fEmail: "Email",
    fPhone: "Phone", fAddress: "Address", fBirth: "Date of birth",
    edit: "Edit", del: "Delete", close: "Close", cancel: "Cancel", save: "Save",
    saveChanges: "Save changes", newTitle: "New student", editTitle: "Edit student",
    badData: "Check the data: National ID and name are required and the email must be valid.",
    saveFail: "Could not save. {msg}", delFail: "Could not delete. {msg}",
    saved: "Student added.", updated: "Student updated.", deleted: "Student deleted.",
    confirmDel: "Delete {name}?",
    p2Search: "Search Pokémon by name", p2SearchAria: "Search Pokémon", p2ListAria: "Pokémon list",
    p2Wait: "Searching in {s} s…", p2Loading: "Loading Pokédex…", p2LoadingCards: "Loading cards…",
    p2NoMatch: "No Pokémon with that name. Try another part of the name.",
    p2Err: "Could not reach PokéAPI. Check your internet connection.",
    more: "Load more", cardDesc: "Height {h} m · Weight {w} kg", no: "No. {n}",
    dLoading: "Loading details…", dNoId: "No Pokémon was specified.",
    dErr: "Could not load the details. Check your internet connection.",
    height: "Height", weight: "Weight", baseExp: "Base experience", abilities: "Abilities",
    stats: "Base stats", evolutions: "Evolutions", noDesc: "No description available."
  },
  es: {
    other: "English", switchLanguage: "Cambiar idioma", navAria: "Menú principal", menu: "Abrir menú",
    appSub: "Gestión de estudiantes", navStudents: "Estudiantes", navApi: "Página 2 (API pública)",
    retry: "Reintentar", back: "Volver", viewAria: "Ver detalle de {name}",
    p1Title: "Estudiantes · Academico", p1Search: "Buscar por nombre, cédula o email",
    p1SearchAria: "Buscar estudiantes", p1Live: "Busca mientras escribes", p1New: "+ Nuevo estudiante",
    p1Count: "Mostrando {n} de {total}", p1ListAria: "Lista de estudiantes", loading: "Cargando estudiantes…",
    noneYet: "Todavía no hay estudiantes. Usa el botón Nuevo estudiante para agregarlos.",
    noMatch: "No hay estudiantes que coincidan con la búsqueda.",
    connErr: "No se pudo conectar con el servidor. Revisa que la app esté corriendo y que abriste esta página desde localhost:8080.",
    idLabel: "Matrícula {id}", fIdNumber: "Cédula", fName: "Nombre completo", fEmail: "Email",
    fPhone: "Teléfono", fAddress: "Dirección", fBirth: "Fecha de nacimiento",
    edit: "Editar", del: "Eliminar", close: "Cerrar", cancel: "Cancelar", save: "Guardar",
    saveChanges: "Guardar cambios", newTitle: "Nuevo estudiante", editTitle: "Editar estudiante",
    badData: "Revisa los datos: cédula y nombre son obligatorios y el email debe ser válido.",
    saveFail: "No se pudo guardar. {msg}", delFail: "No se pudo eliminar. {msg}",
    saved: "Estudiante agregado.", updated: "Estudiante actualizado.", deleted: "Estudiante eliminado.",
    confirmDel: "¿Eliminar a {name}?",
    p2Search: "Buscar Pokémon por nombre", p2SearchAria: "Buscar Pokémon", p2ListAria: "Lista de Pokémon",
    p2Wait: "Buscando en {s} s…", p2Loading: "Cargando Pokédex…", p2LoadingCards: "Cargando tarjetas…",
    p2NoMatch: "No hay Pokémon con ese nombre. Prueba con otra parte del nombre.",
    p2Err: "No se pudo conectar con PokéAPI. Revisa tu internet.",
    more: "Ver más", cardDesc: "Altura {h} m · Peso {w} kg", no: "N.º {n}",
    dLoading: "Cargando detalle…", dNoId: "No se indicó qué Pokémon mostrar.",
    dErr: "No se pudo cargar el detalle. Revisa tu internet.",
    height: "Altura", weight: "Peso", baseExp: "Experiencia base", abilities: "Habilidades",
    stats: "Estadísticas base", evolutions: "Evoluciones", noDesc: "Sin descripción disponible."
  }
};

const TYPE_NAMES_ES = { normal: "Normal", fire: "Fuego", water: "Agua", electric: "Eléctrico", grass: "Planta", ice: "Hielo", fighting: "Lucha", poison: "Veneno", ground: "Tierra", flying: "Volador", psychic: "Psíquico", bug: "Bicho", rock: "Roca", ghost: "Fantasma", dragon: "Dragón", dark: "Siniestro", steel: "Acero", fairy: "Hada" };
const STAT_NAMES = { hp: ["HP", "PS"], attack: ["Attack", "Ataque"], defense: ["Defense", "Defensa"], "special-attack": ["Sp. Atk", "Ataque esp."], "special-defense": ["Sp. Def", "Defensa esp."], speed: ["Speed", "Velocidad"] };

let currentLanguage = "en";
try { currentLanguage = localStorage.getItem("language") === "es" ? "es" : "en"; } catch (e) { /* no storage available: stay in English */ }

// t("key", { name: value }) returns the text in the current language
const t = (key, vars = {}) =>
  (TEXTS[currentLanguage][key] ?? key).replace(/\{(\w+)\}/g, (_, k) => vars[k] ?? "");

const typeName = (name) => currentLanguage === "es" ? (TYPE_NAMES_ES[name] || name) : name.charAt(0).toUpperCase() + name.slice(1);
const statName = (name) => (STAT_NAMES[name] || [name, name])[currentLanguage === "es" ? 1 : 0];

// Updates the fixed texts of the HTML marked with data-i18n
function applyLanguage() {
  document.documentElement.lang = currentLanguage;
  document.querySelectorAll("[data-i18n]").forEach((el) => { el.textContent = t(el.dataset.i18n); });
  document.querySelectorAll("[data-i18n-placeholder]").forEach((el) => { el.placeholder = t(el.dataset.i18nPlaceholder); });
  document.querySelectorAll("[data-i18n-aria]").forEach((el) => { el.setAttribute("aria-label", t(el.dataset.i18nAria)); });
  if (document.body.dataset.titleKey) document.title = t(document.body.dataset.titleKey);
  const button = document.getElementById("languageButton");
  if (button) button.textContent = t("other");
}

function toggleLanguage() {
  currentLanguage = currentLanguage === "en" ? "es" : "en";
  try { localStorage.setItem("language", currentLanguage); } catch (e) { /* ignore */ }
  applyLanguage();
  document.dispatchEvent(new Event("languageChanged")); // each page redraws its dynamic content
}

document.addEventListener("DOMContentLoaded", () => {
  applyLanguage();
  const button = document.getElementById("languageButton");
  if (button) button.addEventListener("click", toggleLanguage);
});
