// Centralized data layer for the PokéAPI
const BASE_URL = "https://pokeapi.co/api/v2/";

export async function api(url, signal = null) {
    // Validate that the URL strictly belongs to the PokéAPI
    if (!url.startsWith("https://pokeapi.co/api/v2/")) {
        throw new Error("URL not allowed by security policy: " + url);
    }

    // Set an 8-second timeout using AbortController
    const controller = new AbortController();
    const timeoutId = setTimeout(() => controller.abort(), 8000);

    // Combine the external signal (if any) with the timeout signal
    const options = {
        signal: signal ? combineSignals(signal, controller.signal) : controller.signal
    };

    try {
        const response = await fetch(url, options);
        clearTimeout(timeoutId);

        if (!response.ok) {
            throw new Error(`Request error: ${response.status} ${response.statusText}`);
        }

        return await response.json();
    } catch (error) {
        clearTimeout(timeoutId);
        if (error.name === 'AbortError') {
            throw new Error('The request exceeded the 8-second time limit or was cancelled.');
        }
        throw error;
    }
}

// Helper to combine cancellation signals
function combineSignals(signal1, signal2) {
    const controller = new AbortController();
    const abort = () => controller.abort();

    signal1.addEventListener('abort', abort);
    signal2.addEventListener('abort', abort);

    return controller.signal;
}