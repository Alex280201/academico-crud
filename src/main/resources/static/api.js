// Capa de datos centralizada para la PokéAPI
const BASE_URL = "https://pokeapi.co/api/v2/";

export async function api(url, signal = null) {
    // Validar que la URL pertenezca estrictamente a la PokéAPI
    if (!url.startsWith("https://pokeapi.co/api/v2/")) {
        throw new Error("URL no permitida por políticas de seguridad: " + url);
    }

    // Configurar el timeout de 8 segundos usando AbortController
    const controller = new AbortController();
    const timeoutId = setTimeout(() => controller.abort(), 8000);

    // Combinar la señal externa (si existe) con la del timeout
    const options = {
        signal: signal ? combineSignals(signal, controller.signal) : controller.signal
    };

    try {
        const response = await fetch(url, options);
        clearTimeout(timeoutId);

        if (!response.ok) {
            throw new Error(`Error en la petición: ${response.status} ${response.statusText}`);
        }

        return await response.json();
    } catch (error) {
        clearTimeout(timeoutId);
        if (error.name === 'AbortError') {
            throw new Error('La petición excedió el tiempo límite de 8 segundos o fue cancelada.');
        }
        throw error;
    }
}

// Utilidad auxiliar para combinar señales de cancelación
function combineSignals(signal1, signal2) {
    const controller = new AbortController();
    const abort = () => controller.abort();

    signal1.addEventListener('abort', abort);
    signal2.addEventListener('abort', abort);

    return controller.signal;
}