from itertools import chain
import json

'''
TODO: tags should probably be stored lowercase in a set, and Title Cased
  on their way back to the user
'''

with open("mock_data.json") as f:
    RESULTS = json.load(f)

def get_categories():
    '''
    Returns {"category": ["sub", "categories"]}
    '''
    categories = {}
    # if there no subcategories
    for category, subcategories in RESULTS.iteritems():
        if isinstance(subcategories, list):
            categories[category] = None
        else:
            categories[category] = subcategories.keys()

    return categories


def get_tips(category=None, subcategory=None, tags=None):
    '''
    Returns a list of maps of the form
    {"tip": "...", "likers": 0, "dislikers": 0, tags: ["..."]}
    '''

    if category is not None:
        return _get_tips(RESULTS[category], subcategory, tags)

    tips = []
    for subcategories in RESULTS.itervalues():
        new_tips = _get_tips(subcategories, subcategory, tags)
        if new_tips is not None:
            tips.extend(new_tips)

    return tips


def _get_tips(subcategories, subcategory, tags):
    # there are no subcategories, just tips for this category
    if isinstance(subcategories, list):
        # if there are no subcategories, then we can't filter on them
        if subcategory is not None:
            return None
        else:
            return filter_tips(subcategories, tags)

    if subcategory is not None:
        tips = subcategories[subcategory]
    else:
        tips = chain(*subcategories.itervalues())

    return filter_tips(tips, tags)


def filter_tips(tips, tags):
    if tags is None:
        return tips

    filtered_tips = []
    for tip in tips:
        if set(tags).issubset(set(tip["tags"])):
            filtered_tips.append(tip)

    return filtered_tips
