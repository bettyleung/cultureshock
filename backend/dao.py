RESULTS = {
    "Food/Dining": {
        "Fine": [
            {
                "tip": "The honoured guest or the eldest is the first person to begin eating.",
                "likers": 0,
                "dislikers": 0,
                "tags": ["Food/Dining", "Fine Dining", "Social"]
            },
            {
                "tip": "Never point your chopsticks. Do not pierce your food with chopsticks.",
                "likers": 0,
                "dislikers": 0,
                "tags": ["Food/Dining", "Fine Dining", "Social"]
            }
        ],
        "Casual": [
            {
                "tip": "Don't be surprised if your Japanese colleagues slurp their noodles and soup.",
                "likers": 0,
                "dislikers": 0,
                "tags": ["Food/Dining", "Casual Dining", "Social"]
            }
        ]
    },
    "Special Occasions": {
        "Holidays": [
            {
                "tip": "<a holiday tip>",
                "likers": 0,
                "dislikers": 0,
                "tags": ["Special Occasions", "Holidays"]
            }
        ],
        "Weddings": [
            {
                "tip": "<a wedding tip>",
                "likers": 0,
                "dislikers": 0,
                "tags": ["Special Occasions", "Weddings"]
            },
        ],
    },
    "Transit": {
        "Public": [
            {
                "tip": "<a public transit tip>",
                "likers": 0,
                "dislikers": 0,
                "tags": ["Transit", "Public"]
            },
        ],
        "Private": [
            {
                "tip": "<a private transit tip>",
                "likers": 0,
                "dislikers": 0,
                "tags": ["Transit", "Private"]
            },
        ],
    },
    "Business": [
        {
            "tip": "One way to build and maintain relationships is with greetings / seasonal cards. It is important to be a good correspondent as the Japanese hold this in high esteem.",
            "likers": 0,
            "dislikers": 0,
            "tags": ["Business"]
        },
        {
            "tip": "Appointments are required and, whenever possible, should be made several weeks in advance.",
            "likers": 0,
            "dislikers": 0,
            "tags": ["Business"]
        },
        {
            "tip": "It is best to telephone for an appointment rather than send a letter, fax or email.",
            "likers": 0,
            "dislikers": 0,
            "tags": ["Business"]
        },
        {
            "tip": "Punctuality is important. Arrive on time for meetings and expect your Japanese colleagues will do the same.",
            "likers": 0,
            "dislikers": 0,
            "tags": ["Business"]
        },
    ]
}

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
