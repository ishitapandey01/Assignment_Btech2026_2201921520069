Get all the select elements, the button, and the time display
let allselect = document.querySelectorAll("select");
let setbut = document.querySelector("button");
let alarmtime = "";
let isAlarmSet = false;
let ringtone = new Audio("ringtone.mp3"); // Make sure the file path is correct

// Function to set the alarm
const setAlarm = () => {
    let selectedTime = `${allselect[0].value}:${allselect[1].value} ${allselect[2].value}`;

    // Validate the selected time
    if (allselect[0].value === "Hour" || allselect[1].value === "Minute" || allselect[2].value === "AM/PM") {
        return swal("Warning", "Please select a valid time", "warning");
    } else {
        alarmtime = selectedTime; // Store the alarm time
        alert(`Alarm set for: ${selectedTime}`); // Show the set alarm time
    }

    // Change button text to indicate alarm is set
    setbut.innerText = "Clear Alarm";

    // Disable the alarm selection UI
    document.querySelector(".content-box").classList.add("disabled");

    isAlarmSet = true; // Set the flag that the alarm is active
};

// Function to clear the alarm
const clearAlarm = () => {
    alarmtime = ""; // Clear the stored alarm time
    isAlarmSet = false; // Reset the flag
    setbut.innerText = "Set Alarm"; // Reset the button text
    document.querySelector(".content-box").classList.remove("disabled"); // Re-enable the UI for setting the alarm
    alert("Alarm cleared");
};

// Event listener for the button to set/clear the alarm
setbut.addEventListener("click", () => {
    if (isAlarmSet) {
        clearAlarm(); // If alarm is set, clear it
    } else {
        setAlarm(); // Otherwise, set a new alarm
    }
});

// Function to check if it's time for the alarm
setInterval(() => {
    let date = new Date();
    let h = date.getHours();
    let m = date.getMinutes();
    let s = date.getSeconds();
    let ampm = "AM";

    if (h >= 12) {
        ampm = "PM";
        if (h > 12) h -= 12;
    }
    if (h === 0) h = 12;

    h = h < 10 ? "0" + h : h;
    m = m < 10 ? "0" + m : m;
    s = s < 10 ? "0" + s : s;

    // Check if the current time matches the alarm time
    if (alarmtime === `${h}:${m} ${ampm}` && isAlarmSet) {
        ringtone.play(); // Play the ringtone
        ringtone.loop = true; // Keep looping until the alarm is stopped
    }
}, 1000); // Check every second

