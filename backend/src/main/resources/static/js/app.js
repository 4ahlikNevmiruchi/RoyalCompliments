const button = document.getElementById('btn');
const messageDiv = document.getElementById('message');
const authorDiv = document.getElementById('author');

button.addEventListener('click', async () => {
    try {
        button.innerHTML = '<span class="spinner-border spinner-border-sm"></span> Consulting...';
        button.disabled = true;

        const response = await fetch('/api/compliment');
        const data = await response.json();

        messageDiv.innerText = `"${data.text}"`;
        authorDiv.innerText = `- ${data.author}`;

    } catch (error) {
        messageDiv.innerText = "The library is on fire.";
        authorDiv.innerText = "";
    } finally {
        button.innerText = 'Consult Again';
        button.disabled = false;
    }
});
/*
addBtn.addEventListener('click', async () => {
    const newCompliment = inputField.value;
    if (!newCompliment) return;

    try {
        addBtn.disabled = true;
        addBtn.innerText = "Saving...";

        await fetch('/api/compliment', {
            method: 'POST',
            body: newCompliment
        });

        inputField.value = "";
        alert("Thy words have been etched into history!");
    } catch (error) {
        alert("Failed to save to the archives.");
    } finally {
        addBtn.disabled = false;
        addBtn.innerText = "Add";
    }
});
*/