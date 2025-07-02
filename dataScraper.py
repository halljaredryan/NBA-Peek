import requests
import csv
from bs4 import BeautifulSoup

URL = "https://www.nbastuffer.com/2024-2025-nba-player-stats/"
resp = requests.get(URL)
resp.raise_for_status()

soup = BeautifulSoup(resp.text, "html.parser")

tables = soup.find_all("table")
print(f"Found {len(tables)} tables.")

for i, table in enumerate(tables):
    table_name = "playoffs" if i == 0 else "regular_season"
    filename = f"nba_player_stats_{table_name}.csv"
    
    with open(filename, "w", newline="", encoding="utf-8") as f:
        writer = csv.writer(f)
        
        headers = [th.get_text(strip=True) for th in table.find_all("th")]
        if not headers:
            first_row = table.find("tr")
            headers = [td.get_text(strip=True) for td in first_row.find_all("td")]
        writer.writerow(headers)
        
        for row in table.find_all("tr")[1:]:
            cols = [td.get_text(strip=True) for td in row.find_all("td")]
            if cols:
                writer.writerow(cols)
    
    print(f"Saved {filename}")

print("All tables saved to separate files.")