# Git Notes — how to commit & push changes in the future

Repo root: this folder (`banking_console_app/`). Always `cd` here before git commands.
Remote: https://github.com/Quadeer-Q/Leaning_Java.git (branch: main)

## See the latest on GitHub Desktop / VS Code
- GitHub Desktop: open the `banking_console_app` folder (File → Add Local Repository → pick `banking_console_app`, NOT `learning_java`), then fetch (Repository → Fetch). If you opened `learning_java`, it shows nothing because there is no git repo there.
- VS Code: just open `banking_console_app` as the workspace folder, or click the source-control refresh icon.
- GitHub website: hard refresh the page (Ctrl+Shift+R).

## Everyday workflow (after editing a file like BankingApp.java)

```bash
cd ~/learning_java/banking_console_app   # always start here
git status                               # see what changed (red = not staged)
git add BankingApp.java                  # stage the file(s) you changed (or: git add .)
git commit -m "short message describing the change"
git push                                 # uploads to GitHub
```

## Rules
1. Never run git commands from `learning_java/` — that's NOT a git repo anymore.
2. Never commit `*.class` files — `.gitignore` already blocks them.
3. One commit = one logical change, with a clear message.
4. `git status` is your friend — run it before and after add/commit.

## Useful extras
- `git log --oneline` — see past commits
- `git diff` — see exactly what you changed before staging
- `git pull` — grab latest from GitHub if you edited on another machine

## What was done on Oct 6 2026
1. `rm -rf /home/quadeer/learning_java/.git` — removed the wrongly placed git repo.
2. `rm /home/quadeer/learning_java/.gitignore` — removed ignore file from the non-repo folder.
3. `cd banking_console_app && git init` — made THIS folder the repo.
4. `git remote add origin https://github.com/Quadeer-Q/Leaning_Java.git` — linked GitHub.
5. `git branch -M main` — renamed default branch to main.
6. `git add .` — staged only .gitignore and BankingApp.java (classes ignored).
7. `git commit -m "Add BankingApp console app with .gitignore"`.
8. `git push -u origin main` — uploaded; `-u` links local main to remote main.
