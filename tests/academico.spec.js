import { test, expect } from '@playwright/test';

test('página 1: muestra la lista y el buscador', async ({ page }) => {
    await page.goto('/pagina1.html');
    await expect(page.locator('#buscar')).toBeVisible();
    await expect(page.locator('#grid')).toBeVisible();
});

test('página 2: carga tarjetas de Pokémon desde PokéAPI', async ({ page }) => {
    await page.goto('/pagina2.html');
    await expect(page.locator('#grid .tarjeta').first()).toBeVisible({ timeout: 20000 });
});

test('detalle: encadena pokemon -> especie -> cadena evolutiva', async ({ page }) => {
    await page.goto('/detalle.html?id=25');
    await expect(page.locator('h1')).toHaveText(/pikachu/i, { timeout: 20000 });
    await expect(page.locator('.evo').first()).toBeVisible();
});