@echo off
REM Windows Batch script to launch TextExtractor in Android Studio
setlocal

set "PROJECT_PATH=%~dp0Completed-Apps\mlkit-apps\TextExtractor"
set "STUDIO_PATH="

REM Check default installation paths for Android Studio on Windows
if exist "%ProgramFiles%\Android\Android Studio\bin\studio64.exe" (
    set "STUDIO_PATH=%ProgramFiles%\Android\Android Studio\bin\studio64.exe"
) else if exist "%LOCALAPPDATA%\Programs\Android Studio\bin\studio64.exe" (
    set "STUDIO_PATH=%LOCALAPPDATA%\Programs\Android Studio\bin\studio64.exe"
) else (
    REM Try searching system PATH
    where studio64.exe >nul 2>nul && set "STUDIO_PATH=studio64.exe"
)

if not "%STUDIO_PATH%"=="" (
    echo Launching Android Studio with project: "%PROJECT_PATH%"
    start "" "%STUDIO_PATH%" "%PROJECT_PATH%"
    ping -n 4 127.0.0.1 >nul
) else (
    echo Android Studio [studio64.exe] was not found in default locations or system PATH.
    echo Please make sure Android Studio is installed, or open the folder "%PROJECT_PATH%" manually.
    pause
)

endlocal
