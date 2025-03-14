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


let storedItemData;
//retreive a list of all the menu item options, then sort them by match to currentValue
let optionTitles = [];



async function configureSearchFunctionality() {
    let searchInput = document.getElementById("search-bar-input");
    let searchItemsContainer = document.getElementById("menu-search-items-container");
    let itemsToAddContainer = document.getElementById("menu-search-results-container");
    let categoriesContainer = document.getElementById("menu-categories-container");
    let menuBanner = document.getElementById("menu-banner");

    let isOpen = (searchItemsContainer.style.display === "flex");

    optionTitles = [];
    for (const title of document.getElementsByClassName("item-title")) {
        let value = title.textContent;
        if (!optionTitles.includes(value)) {
            optionTitles.push(value);
        }
    }
    optionTitles.sort();

    //logic to close the search area when the user tries to click out of it.
    searchItemsContainer.addEventListener("click", (e) => {
        if (itemsToAddContainer.contains(e.target)) {
            e.preventDefault();
            return;
        }
        searchBoxClose();
        isOpen = false;
    });
    menuBanner.addEventListener("click", () => {
        searchBoxClose();
        isOpen = false;
    });
    //if focusing on the searchInput box, keep it open.
    searchInput.addEventListener("focusin", () => {
        if (!isOpen) {
            searchBoxOpen();
            isOpen = true;
        }
    });
    //todo transform the search label into an exit button when the search area is active, just to make nav even more obv
    //logic to consume clicks to search-related elements, preventing the search area from closing accidentally.
    document.getElementById("search-bar-label").addEventListener("click", (e) => {
        e.preventDefault();
        e.stopPropagation();
        if (!isOpen) {
            searchBoxOpen();
            isOpen = true;
        } else {
            searchBoxClose();
            isOpen = false;
        }
    });
    searchInput.addEventListener("click", (e) => {
        e.preventDefault();
        e.stopPropagation();
        if (!isOpen) {
            searchBoxOpen();
            isOpen = true;
        }
    });


    //retrieve extra data for menu items
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
    storedItemData = await request.json();
    console.log("Retrieved images for search...");
    console.log(storedItemData);

    //handle text change logic
    searchInput.addEventListener("input", () => {
        let currentValue = searchInput.value;
        if (currentValue === "") {
            searchBoxClose();
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
        itemsToAddContainer.innerHTML = "";
        for (const item of matchedTerms) {
            let itemData = storedItemData[item];
            let url = itemData["image"];
            itemsToAddContainer.innerHTML += `
            <div class="menu-search-result">
                <div class="menu-search-result-image-container">
                    <img src="${url}">
                </div>
                <div class="menu-search-result-info">
                    <h2 class="menu-search-result-info-title">${item}</h2>
                </div>
            </div>
            `
        }
        for (const target of itemsToAddContainer.getElementsByClassName("menu-search-result")) {
            target.addEventListener("click", (e) => {
                let name = target.getElementsByClassName("menu-search-result-info-title")[0].textContent;
                retrieveItemData(name);
            })
        }
    })
}


function searchBoxClose() {
    let searchInput = document.getElementById("search-bar-input");
    let searchItemsContainer = document.getElementById("menu-search-items-container");
    let categoriesContainer = document.getElementById("menu-categories-container");
    let menuBanner = document.getElementById("menu-banner");
    let searchIcon = document.getElementById("search-label-icon-search");
    let closeIcon = document.getElementById("search-label-icon-close");

    gsap.to(closeIcon, {
        opacity: 0,
        duration: 0.25,
        ease: "power1.inout",
        onComplete: () => {
            closeIcon.style.opacity = "1";
            closeIcon.style.display = "none";
            searchIcon.style.display = "block";
            gsap.from(searchIcon, {
                opacity: 0,
                duration: 0.25,
                ease: "power1.inout"
            });
        }
    });

    gsap.to(searchItemsContainer, {
        opacity: 0,
        duration: 0.25,
        ease: "power1.inout",
        onComplete: () => {
            searchItemsContainer.style.display = "none";
            searchItemsContainer.style.opacity = "1";

        }
    });

    let distance = Math.min(window.scrollY || 0, window.innerHeight * 0.23);
    gsap.to(menuBanner, {
        y: -1 * distance,
        duration: 0.25,
        ease: "power1.inout",
        onComplete: () => {
            categoriesContainer.style.paddingTop = "0";
            menuBanner.style.position = "static";
            gsap.set(menuBanner, {y:0});
        }
    })
}


function searchBoxOpen() {
    let searchInput = document.getElementById("search-bar-input");
    let searchItemsContainer = document.getElementById("menu-search-items-container");
    let categoriesContainer = document.getElementById("menu-categories-container");
    let itemsToAddContainer = document.getElementById("menu-search-results-container");
    let menuBanner = document.getElementById("menu-banner");
    let searchIcon = document.getElementById("search-label-icon-search");
    let closeIcon = document.getElementById("search-label-icon-close");

    gsap.to(searchIcon, {
        opacity: 0,
        duration: 0.25,
        ease: "power1.inout",
        onComplete: () => {
            searchIcon.style.opacity = "1";
            searchIcon.style.display = "none";
            closeIcon.style.display = "block";
            gsap.from(closeIcon, {
                opacity: 0,
                duration: 0.25,
                ease: "power1.inout"
            });
        }
    });


    searchItemsContainer.style.display = "flex";
    searchItemsContainer.style.opacity = "0";
    categoriesContainer.style.paddingTop = "23vh";
    menuBanner.style.position = "fixed";
    //if the box is open but the content is empty, then show ALL options.
    itemsToAddContainer.innerHTML = "";
    for (const item of optionTitles) {
        let itemData = storedItemData[item];
        let url = itemData["image"];
        itemsToAddContainer.innerHTML += `
            <div class="menu-search-result">
                <div class="menu-search-result-image-container">
                    <img src="${url}">
                </div>
                <div class="menu-search-result-info">
                    <h2 class="menu-search-result-info-title">${item}</h2>
                </div>
            </div>
            `
    }
    for (const target of itemsToAddContainer.getElementsByClassName("menu-search-result")) {
        target.addEventListener("click", (e) => {
            let name = target.getElementsByClassName("menu-search-result-info-title")[0].textContent;
            retrieveItemData(name);
        });
    }

    gsap.from(menuBanner, {
        y: -1 * Math.max(0, window.scrollY),
        duration: 0.25,
        ease: "power1.inout"
    })

    gsap.to(searchItemsContainer, {
        opacity: 1,
        duration: 0.25,
        ease: "power1.inout",
    });

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