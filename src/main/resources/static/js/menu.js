function initMenu() {
    setMenuCategory("All");

    configureSearchFunctionality();
}


function mobileNavAccordionClick(mode) {
    if (mode === 'show') {
        document.getElementById("menu-accordion-panel").setAttribute("data-hide", "false");
        document.getElementById("show-accordion-panel").style.display = "none";
        document.getElementById("hide-accordion-panel").style.display = "block";
    } else {
        document.getElementById("menu-accordion-panel").setAttribute("data-hide", "true");
        document.getElementById("show-accordion-panel").style.display = "block";
        document.getElementById("hide-accordion-panel").style.display = "none";
    }
}



async function configureSearchFunctionality() {
    let searchInput = document.getElementById("search-bar-input");
    let searchItemsContainer = document.getElementById("menu-search-items-container");
    let itemsToAddContainer = document.getElementById("menu-search-results-container");
    let categoriesContainer = document.getElementById("menu-categories-container");
    let menuBanner = document.getElementById("menu-banner");

    let isOpen = (searchItemsContainer.style.display === "flex");

    //retreive a list of all the menu item options, then sort them by match to currentValue
    let optionTitles = [];
    for (const title of document.getElementsByClassName("item-title")) {
        let value = title.textContent;
        if (!optionTitles.includes(value)) {
            optionTitles.push(value);
        }
    }
    optionTitles.sort();

    const request = await fetch("/menu", {
        "method": "POST",
        "body": JSON.stringify({
            "isdatarequest": true,
            "batch": true
        }),
        "headers": {
            "Content-type": "application/json; charset=UTF-8"
        }
    });
    const storedItemData = await request.json();
    console.log(storedItemData);

    searchInput.addEventListener("input", () => {
        let currentValue = searchInput.value;


        if (currentValue === "") {
            searchBoxClose(); //todo add close functionality if the user clicks outside of the itemsToAddContainer area
            isOpen = false;
            return;
        }

        if (!isOpen) {
            searchBoxOpen();
            isOpen = true;
        }

        let matchedTerms = optionTitles.filter((val) => val.toLowerCase().includes(currentValue.toLowerCase()));
        if (matchedTerms.length === 0) {
            //no matching terms, do something to display this.
        }
        matchedTerms.sort((a, b) => {
            let aDist = ("" + a.toLowerCase()).indexOf(currentValue.toLowerCase());
            let bDist = ("" + b.toLowerCase()).indexOf(currentValue.toLowerCase());
            if (aDist === bDist) {
                return a.toLowerCase().localeCompare(b.toLowerCase());
            }
            return aDist - bDist;
        });
        itemsToAddContainer.innerHTML = ""; //todo scroll automatically.
        for (const item of matchedTerms) {
            let itemData = storedItemData[item];
            let url = itemData["image"];
            let description = itemData["desc"];
            itemsToAddContainer.innerHTML += `
            <div class="menu-search-result">
                <div class="menu-search-result-image-container">
                    <img src="${url}">
                </div>
                <div class="menu-search-result-info">
                    <h2>${item}</h2>
                    <p>${description}</p>
                </div>
            </div>
            `
        }

    })
}


function searchBoxClose() {
    let searchInput = document.getElementById("search-bar-input");
    let searchItemsContainer = document.getElementById("menu-search-items-container");
    let categoriesContainer = document.getElementById("menu-categories-container");
    let menuBanner = document.getElementById("menu-banner");
    searchItemsContainer.style.display = "none";
    categoriesContainer.style.paddingTop = "0";
    menuBanner.style.position = "static";
}


function searchBoxOpen() {
    let searchInput = document.getElementById("search-bar-input");
    let searchItemsContainer = document.getElementById("menu-search-items-container");
    let categoriesContainer = document.getElementById("menu-categories-container");
    let menuBanner = document.getElementById("menu-banner");
    searchItemsContainer.style.display = "flex";
    categoriesContainer.style.paddingTop = "23vh";
    menuBanner.style.position = "fixed";
}


function clearSearchOptions() {

}


function addSearchOptions() {

}




function setMenuCategory(targetCategory) {
    document.getElementById("nav-accordion-header-label").textContent = targetCategory;

    let targetContainer = document.getElementById("menucontainer_" + targetCategory);
    let clicked = document.getElementById("cattile_" + targetCategory);

    for (const tile of document.getElementsByClassName("menu-topic-tile")) {
        if (tile.getAttribute("id") === "cattile_" + targetCategory) {
            tile.classList.add("category-selected");
        } else {
            tile.classList.remove("category-selected");
        }
    }

    for (const container of document.getElementsByClassName("menu-items")) {
        if (container.getAttribute("id") === "menucontainer_" + targetCategory) {
            container.setAttribute("style", "display: flex;");
        } else {
            container.setAttribute("style", "display: none;");
        }
    }

    gsap.set(document.getElementsByClassName("menu-tag-name"), {
        opacity: 0})
    gsap.set(document.getElementsByClassName("menu-item"), {
        opacity: 0})

    gsap.to(document.getElementsByClassName("menu-tag-name"), {opacity: 1, duration: 0.5, ease: "power1.in"});
    gsap.to(document.getElementsByClassName("menu-item"), {opacity: 1, duration: 0.5, ease: "power1.in"});
}