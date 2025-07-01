import requests
import csv
from bs4 import BeautifulSoup

URL = "https://www.nbastuffer.com/2024-2025-nba-player-stats/"
resp = requests.get(URL)
resp.raise_for_status()

soup = BeautifulSoup(resp.text, "html.parser")

# The stats tables: first table is "Playoffs", second is "Regular Season"
tables = soup.find_all("table")
print(f"Found {len(tables)} tables.")

with open("nba_player_stats.csv", "w", newline="", encoding="utf-8") as f:
    writer = csv.writer(f)
    for table in tables:
        # header row
        headers = [th.get_text(strip=True) for th in table.find_all("th")]
        if not headers:
            # fallback: first row 'td's
            first_row = table.find("tr")
            headers = [td.get_text(strip=True) for td in first_row.find_all("td")]
        writer.writerow(headers)
        
        for row in table.find_all("tr")[1:]:
            cols = [td.get_text(strip=True) for td in row.find_all("td")]
            if cols:
                writer.writerow(cols)

print("Saved nba_player_stats.csv")