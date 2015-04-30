/*************************************************
 * @fileoverview Script to use regex for table
 * suggestions and search.
 *
 * @author ryanspoone@gmail.com (Ryan Spoone)
 *************************************************/


/*jslint browser: true, regexp: true, unparam: true, plusplus: true*/
/*global $, jQuery, alert*/


var searchString = '', // our search string value
    nameArray = [], // unqiue names in the table
    searchArray = [], // our search string values split into an array
    tableRows = $('tbody tr'), // cached element of our table rows
    suggElement = $('#suggestions'), // cached element of our suggestions container element
    suggResElement = $('#suggestion-results'), // cached element of our suggestion results container element
    searchElement = $('#search'), // cached element of our search input
    noRowsElement = $('#no-rows'), // cached element of the no rows display
    noNameElement, // cached element of the no name suggestions display
    suggTimer = 0; // our suggestion timer


/*************************************************
 * @desc Function to clear the suggestion timer
 *************************************************/
function clearSuggTimer() {
    'use strict';
    // if there is currently an active suggestion timer
    if (suggTimer) {
        // clear the suggestion timer
        clearTimeout(suggTimer);
        suggTimer = null;
    }
}


/*************************************************
 * @desc Function to retreive each name from each
 * table row, then add them to the nameArray if
 * they are unique.
 *************************************************/
function getNames() {
    'use strict';
    var nameFound,
        name;
    // each table row
    Array.prototype.forEach.call(tableRows, function (val, i) {
        // the first td is the name
        name = $(val).children('td:eq(1)').text();
        // test if the current name is in our nameArray
        nameFound = $.inArray(name, nameArray);
        // if this name is unique
        if (nameFound < 0) {
            // add to nameArray
            nameArray.push(name);
        }
    });
}


/*************************************************
 * @desc Function to search each table row for the
 * search terms in the searchArray. Then, hide the
 * table rows that are not found and show the
 * table rows that are found.
 *************************************************/
function search() {
    'use strict';
    // close suggestions
    suggElement.hide();
    // clear suggestion timer
    clearSuggTimer();
    // set benchmark found count
    var resultCount = 0;
    // hide our no rows found element
    noRowsElement.hide();
    // for each table row
    Array.prototype.forEach.call(tableRows, function (val, i) {
        // if there is a searchString value
        if (searchString) {
            var text = $(val).children('td:eq(1)').text().toLowerCase(), // first td of row
                regexArray = [],
                regexString,
                regex,
                found,
                j;
            // create a substring regex for every value in the stringArray
            for (j = 0; j < searchArray.length; ++j) {
                regexArray.push('(?=.*\\b.*', searchArray[j], '.*\\b)');
            }
            regexArray.push('.*$');
            // regexArray to string
            regexString = regexArray.join('');
            // convert the regex string to an regular expression
            regex = new RegExp(regexString);
            // test the regular expression against the first td of this row
            found = regex.test(text);
            // if it isn't found, hide this row, else, show this row and add to the resultCount
            if (!found) {
                $(val).hide();
            } else {
                $(val).show();
                ++resultCount;
            }
        } else {
            // if there isn't any searchString, show all rows
            $(val).show();
            ++resultCount;
        }
    });

    // if no rows were found, display #no-rows
    if (resultCount === 0) {
        noRowsElement.show();
    }
}


/*************************************************
 * @desc Function to handle click events for the
 * desired suggestion.
 *************************************************/
function makeClickHandler() {
    'use strict';
    return function () {
        // clear suggestion timer
        clearSuggTimer();
        // get the value from this
        var value = $(this).val();
        // set the search input to this value
        searchElement.val(value);
        // close suggestions
        suggElement.hide();
        // lowercase, remove multiple whitespace, trim whitespace on the
        // front and back, and then remove non-alphanumeric chars
        searchString = value.toLowerCase().trim().replace(/\s{2,}/g, ' ').replace(/\W/g, ' ');
        // split search string into array
        searchArray = searchString.split(' ');
        // search
        search();
    };
}


/*************************************************
 * @desc Function to create suggestions on the DOM
 *************************************************/
function createSuggestions() {
    'use strict';
    var suggResContents = [],
        suggResContentsString = '',
        value,
        i;

    // for every name in the nameArray
    for (i = 0; i < nameArray.length; ++i) {
        value = nameArray[i];
        // create an input for said name
        suggResContents.push('<input id="name-', i, '" class="btn block-center btn-suggest" type="button" value="', value, '" style="display:none;" />');
    }
    // create a span for no names
    suggResContents.push('<span id="no-name" class="block-center" style="display:none;"><p></p>No suggestions available.<p></p></span>');
    // join the array
    suggResContentsString = suggResContents.join('');
    // add names and no names to the suggestion result element
    suggResElement.html(suggResContentsString);
    // cache no name suggestions element
    noNameElement = $('#no-name');
    // create an event for each name suggestion to call the makeClickHandler() function
    for (i = 0; i < nameArray.length; ++i) {
        $('#name-' + i).bind('mouseup click', makeClickHandler());
    }
}


/*************************************************
 * @desc Function to show suggestions when the
 * user is typing in the search input.
 *************************************************/
function suggest() {
    'use strict';
    var nameCount = 0,
        currentNameStringLower,
        regexArray = [],
        regexString,
        regex,
        name,
        found,
        i,
        j;
    // hide #no-name
    noNameElement.hide();
    for (i = 0; i < nameArray.length; ++i) {
        // only display a max of 5 suggestions
        if (nameCount < 5) {
            // the current name in the nameArray
            name = nameArray[i];
            // lowercase, remove multiple whitespace, trim whitespace on the
            // front and back, and then remove non-alphanumeric chars
            currentNameStringLower = name.toLowerCase().replace(/\s{2,}/g, ' ').trim().replace(/\W/g, ' ');
            // clear the regex array
            regexArray = [];

            // regex substrings for each item in the searchArray
            for (j = 0; j < searchArray.length; ++j) {
                regexArray.push('(?=.*\\b.*', searchArray[j], '.*\\b)');
            }
            regexArray.push('.*$');
            // regexArray to regexString
            regexString = regexArray.join('');
            // convert the regex string to an regular expression
            regex = new RegExp(regexString);
            // test the regular expression against the first td of this row
            found = regex.test(currentNameStringLower);
            // if the regex test succeeds, show the suggestion that passes
            if (found) {
                $('#name-' + i).show();
                ++nameCount;
            }
        } else {
            break;
        }
    }
    // if no suggestions, display #no-name
    if (nameCount === 0) {
        noNameElement.show();
    }
}


/*************************************************
 * When the page that is calling this script is
 * ready.
 *************************************************/
$(document).ready(function () {
    'use strict';

    // the main function to run after a second after the DOM is ready
    // to generate the namesArray and create the suggestion elements
    function mainRun() {
        setTimeout(function () {
            getNames();
            createSuggestions();
        }, 1000);
    }
    mainRun();

    // if the search input is changed
    searchElement.bind('keyup change', function (e) {
        var searchValue = $(this).val(),
            code = e.keyCode || e.which;
        // if [Enter] has been pressed
        if (code === 13) {
            e.preventDefault();
            // clear suggestion timer
            clearSuggTimer();
            // search
            search();
        } else {
            // only if there is a search value
            if (searchValue) {
                // lowercase, remove multiple whitespace, trim whitespace on the
                // front and back, and then remove non-alphanumeric chars
                searchString = searchValue.toLowerCase().replace(/\s{2,}/g, ' ').trim().replace(/\W/g, ' ');
                // split search string into
                searchArray = searchString.split(' ');
                // remove empty elements
                searchArray.filter(Boolean);
                // clear suggestion timer
                clearSuggTimer();
                // so the suggestions don't get overwhelmed,
                // wait until the user is roughly finished typing (.7 sec)
                // before calling the suggestion function
                suggTimer = setTimeout(function () {
                    // make suggestions visible
                    suggResElement.children().hide();
                    // show #suggestions
                    suggElement.show();
                    // display suggestions
                    suggest();
                }, 700);
            } else {
                searchString = searchValue;
                // clear suggestion timer
                clearSuggTimer();
                // hide #suggestions
                suggElement.hide();
            }
        }
    });

    // hide suggestions if clicked outside of suggestion container
    $(document).bind('mouseup click', function (e) {
        // clear suggestion timer
        clearSuggTimer();
        // if click outside of the suggestion element
        if (!suggElement.is(e.target) && suggElement.has(e.target).length === 0) {
            clearSuggTimer();
            // hide the suggestion element
            suggElement.hide();
        }
    });
});