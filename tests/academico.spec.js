import { test, expect } from '@playwright/test';

test('students page: shows the list and the search box', async ({ page }) => {
    await page.goto('/students.html');
    await expect(page.locator('#search')).toBeVisible();
    await expect(page.locator('#grid')).toBeVisible();
});

test('pokemon page: loads Pokémon cards from the PokéAPI', async ({ page }) => {
    await page.goto('/pokemon.html');
    await expect(page.locator('#grid .card').first()).toBeVisible({ timeout: 20000 });
});

test('detail page: chains pokemon -> species -> evolution chain', async ({ page }) => {
    await page.goto('/detail.html?id=25');
    await expect(page.locator('h1')).toHaveText(/pikachu/i, { timeout: 20000 });
    await expect(page.locator('.evo').first()).toBeVisible();
});
