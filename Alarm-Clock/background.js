chrome.runtime.onInstalled.addListener(() => {
    console.log('Alarm Clock Extension Installed');
});
chrome.alarms.onAlarm.addListener((alarm) => {
    if (alarm.name === "ringAlarm") {
        chrome.notifications.create({
            type: "basic",
            iconUrl: "icons/icon128.png",
            title: "Alarm!",
            message: "Your alarm is ringing!",
            priority: 2
        });
    }
});
