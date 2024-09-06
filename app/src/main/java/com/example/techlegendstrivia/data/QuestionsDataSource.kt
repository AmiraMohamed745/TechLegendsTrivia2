package com.example.techlegendstrivia.data

import com.example.techlegendstrivia.R
import com.example.techlegendstrivia.model.Level
import com.example.techlegendstrivia.model.Question
import com.example.techlegendstrivia.ui.ui.state.MAX_QUESTION_NUMBER

class QuestionsDataSource {

    private val easyQuestionsList = listOf(
        Question(
            question = R.string.question_co_founder_microsoft,
            multipleChoices = listOf(
                R.string.choice_steve_jobs,
                R.string.choice_mark_zuckerberg,
                R.string.choice_bill_gates,
                R.string.choice_larry_page
            ),
            correctAnswer = R.string.choice_bill_gates
        ),
        Question(
            question = R.string.question_steve_jobs_company,
            multipleChoices = listOf(
                R.string.choice_microsoft,
                R.string.choice_apple,
                R.string.choice_amazon,
                R.string.choice_google
            ),
            correctAnswer = R.string.choice_apple
        ),
        Question(
            question = R.string.question_first_programmable_computer,
            multipleChoices = listOf(
                R.string.choice_eniac,
                R.string.choice_univac,
                R.string.choice_ibm_pc,
                R.string.choice_apple_i
            ),
            correctAnswer = R.string.choice_eniac
        ),
        Question(
            question = R.string.question_inventor_www,
            multipleChoices = listOf(
                R.string.choice_steve_wozniak,
                R.string.choice_mark_zuckerberg,
                R.string.choice_berners_lee,
                R.string.choice_gates
            ),
            correctAnswer = R.string.choice_berners_lee
        ),
        Question(
            question = R.string.question_microsoft_co_founder,
            multipleChoices = listOf(
                R.string.choice_steve_jobs,
                R.string.choice_paul_allen,
                R.string.choice_mark_zuckerberg,
                R.string.choice_larry_page
            ),
            correctAnswer = R.string.choice_paul_allen
        ),
        Question(
            question = R.string.question_first_amazon_product,
            multipleChoices = listOf(
                R.string.choice_online_bookstore,
                R.string.choice_social_network,
                R.string.choice_search_engine,
                R.string.choice_smartphone
            ),
            correctAnswer = R.string.choice_online_bookstore
        ),
        Question(
            question = R.string.question_python_creator,
            multipleChoices = listOf(
                R.string.choice_java,
                R.string.choice_python,
                R.string.choice_ruby,
                R.string.choice_cplusplus
            ),
            correctAnswer = R.string.choice_python
        ),
        Question(
            question = R.string.question_elon_musk_company,
            multipleChoices = listOf(
                R.string.choice_tesla,
                R.string.choice_nissan,
                R.string.choice_chevrolet,
                R.string.choice_ford
            ),
            correctAnswer = R.string.choice_tesla
        ),
        Question(
            question = R.string.question_zuckerberg_platform,
            multipleChoices = listOf(
                R.string.choice_tiktok,
                R.string.choice_facebook,
                R.string.choice_twitter,
                R.string.choice_instagram
            ),
            correctAnswer = R.string.choice_facebook
        ),
        Question(
            question = R.string.question_founder_spacex,
            multipleChoices = listOf(
                R.string.choice_larry_page,
                R.string.choice_elon_musk,
                R.string.choice_richard_branson,
                R.string.choice_jeff_bezos
            ),
            correctAnswer = R.string.choice_elon_musk
        ),
        Question(
            question = R.string.question_larry_ellison_company,
            multipleChoices = listOf(
                R.string.choice_ibm,
                R.string.choice_salesforce,
                R.string.choice_sap,
                R.string.choice_oracle
            ),
            correctAnswer = R.string.choice_oracle
        ),
        Question(
            question = R.string.question_facebook_acquisition,
            multipleChoices = listOf(
                R.string.choice_whatsapp,
                R.string.choice_telegram,
                R.string.choice_snapchat,
                R.string.choice_wechat
            ),
            correctAnswer = R.string.choice_whatsapp
        ),
        Question(
            question = R.string.question_twitter_ceo,
            multipleChoices = listOf(
                R.string.choice_parag_agrawal,
                R.string.choice_sundar_pichai,
                R.string.choice_jack_dorsey,
                R.string.choice_elon_musk
            ),
            correctAnswer = R.string.choice_elon_musk
        ),
        Question(
            question = R.string.question_ibm_inspiration,
            multipleChoices = listOf(
                R.string.choice_apple,
                R.string.choice_dell,
                R.string.choice_hp,
                R.string.choice_compaq
            ),
            correctAnswer = R.string.choice_compaq
        ),
        Question(
            question = R.string.question_first_gui_pc,
            multipleChoices = listOf(
                R.string.choice_windows,
                R.string.choice_commodore_pet,
                R.string.choice_apple_macintosh,
                R.string.choice_ibm_pc
            ),
            correctAnswer = R.string.choice_apple_macintosh
        ),
        Question(
            question = R.string.question_google_ceo,
            multipleChoices = listOf(
                R.string.choice_facebook,
                R.string.choice_amazon,
                R.string.choice_google,
                R.string.choice_microsoft
            ),
            correctAnswer = R.string.choice_google
        ),
        Question(
            question = R.string.question_steve_jobs_ventures,
            multipleChoices = listOf(
                R.string.choice_tim_cook,
                R.string.choice_elon_musk,
                R.string.choice_steve_jobs,
                R.string.choice_steve_wozniak
            ),
            correctAnswer = R.string.choice_steve_jobs
        ),
        Question(
            question = R.string.question_www_inventor,
            multipleChoices = listOf(
                R.string.choice_bill_gates,
                R.string.choice_vint_cerf,
                R.string.choice_larry_page,
                R.string.choice_berners_lee
            ),
            correctAnswer = R.string.choice_berners_lee
        ),
        Question(
            question = R.string.question_first_sony_console,
            multipleChoices = listOf(
                R.string.choice_xbox,
                R.string.choice_nintendo_64,
                R.string.choice_playstation,
                R.string.choice_sega_genesis
            ),
            correctAnswer = R.string.choice_playstation
        ),
        Question(
            question = R.string.question_andy_rubin_os,
            multipleChoices = listOf(
                R.string.choice_linux,
                R.string.choice_windows,
                R.string.choice_android,
                R.string.choice_macos
            ),
            correctAnswer = R.string.choice_android
        )
    )
    private val mediumQuestionsList = listOf(
        Question(
            question = R.string.question_c_creator,
            multipleChoices = listOf(
                R.string.choice_james_gosling,
                R.string.choice_dennis_ritchie,
                R.string.choice_guido_van_rossum,
                R.string.choice_bjarne_stroustrup
            ),
            correctAnswer = R.string.choice_dennis_ritchie
        ),
        Question(
            question = R.string.question_photoshop_creator,
            multipleChoices = listOf(
                R.string.choice_microsoft,
                R.string.choice_adobe,
                R.string.choice_apple,
                R.string.choice_autodesk
            ),
            correctAnswer = R.string.choice_adobe
        ),
        Question(
            question = R.string.question_first_oop_language,
            multipleChoices = listOf(
                R.string.choice_c,
                R.string.choice_simula,
                R.string.choice_python,
                R.string.choice_java
            ),
            correctAnswer = R.string.choice_simula
        ),
        Question(
            question = R.string.question_first_compiler_creator,
            multipleChoices = listOf(
                R.string.choice_grace_hopper,
                R.string.choice_steve_jobs,
                R.string.choice_alan_turing,
                R.string.choice_gordon_moore
            ),
            correctAnswer = R.string.choice_grace_hopper
        ),
        Question(
            question = R.string.question_linux_creator,
            multipleChoices = listOf(
                R.string.choice_ken_thompson,
                R.string.choice_richard_stallman,
                R.string.choice_linus_torvalds,
                R.string.choice_andrew_tanenbaum
            ),
            correctAnswer = R.string.choice_linus_torvalds
        ),
        Question(
            question = R.string.question_computer_father,
            multipleChoices = listOf(
                R.string.choice_charles_babbage,
                R.string.choice_john_atanasoff,
                R.string.choice_konrad_zuse,
                R.string.choice_alan_turing
            ),
            correctAnswer = R.string.choice_charles_babbage
        ),
        Question(
            question = R.string.question_java_developer,
            multipleChoices = listOf(
                R.string.choice_microsoft,
                R.string.choice_ibm,
                R.string.choice_sun_microsystems,
                R.string.choice_apple
            ),
            correctAnswer = R.string.choice_sun_microsystems
        ),
        Question(
            question = R.string.question_unix_co_creator,
            multipleChoices = listOf(
                R.string.choice_ken_thompson,
                R.string.choice_john_atanasoff,
                R.string.choice_james_gosling,
                R.string.choice_bjarne_stroustrup
            ),
            correctAnswer = R.string.choice_ken_thompson
        ),
        Question(
            question = R.string.question_first_commercial_computer,
            multipleChoices = listOf(
                R.string.choice_apple_i,
                R.string.choice_ibm_pc,
                R.string.choice_univac,
                R.string.choice_eniac
            ),
            correctAnswer = R.string.choice_univac
        ),
        Question(
            question = R.string.question_markup_language_web,
            multipleChoices = listOf(
                R.string.choice_java,
                R.string.choice_xml,
                R.string.choice_http,
                R.string.choice_html
            ),
            correctAnswer = R.string.choice_html
        ),
        Question(
            question = R.string.question_ai_go_champion,
            multipleChoices = listOf(
                R.string.choice_watson,
                R.string.choice_siri,
                R.string.choice_alphago,
                R.string.choice_deep_blue
            ),
            correctAnswer = R.string.choice_alphago
        ),
        Question(
            question = R.string.question_windows_creator,
            multipleChoices = listOf(
                R.string.choice_ibm,
                R.string.choice_apple,
                R.string.choice_oracle,
                R.string.choice_microsoft
            ),
            correctAnswer = R.string.choice_microsoft
        ),
        Question(
            question = R.string.question_current_apple_ceo,
            multipleChoices = listOf(
                R.string.choice_steve_jobs,
                R.string.choice_sundar_pichai,
                R.string.choice_tim_cook,
                R.string.choice_bill_gates
            ),
            correctAnswer = R.string.choice_tim_cook
        ),
        Question(
            question = R.string.question_google_co_founder,
            multipleChoices = listOf(
                R.string.choice_sundar_pichai,
                R.string.choice_steve_jobs,
                R.string.choice_sergey_brin,
                R.string.choice_bill_gates
            ),
            correctAnswer = R.string.choice_sergey_brin
        ),
        Question(
            question = R.string.question_first_web_browser,
            multipleChoices = listOf(
                R.string.choice_internet_explorer,
                R.string.choice_mozilla_firefox,
                R.string.choice_google_chrome,
                R.string.choice_netscape_navigator
            ),
            correctAnswer = R.string.choice_netscape_navigator
        ),
        Question(
            question = R.string.question_ruby_creator,
            multipleChoices = listOf(
                R.string.choice_guido_van_rossum,
                R.string.choice_yukihiro_matsumoto,
                R.string.choice_james_gosling,
                R.string.choice_dennis_ritchie
            ),
            correctAnswer = R.string.choice_yukihiro_matsumoto
        ),
        Question(
            question = R.string.question_front_page_internet,
            multipleChoices = listOf(
                R.string.choice_twitter,
                R.string.choice_google_news,
                R.string.choice_facebook,
                R.string.choice_reddit
            ),
            correctAnswer = R.string.choice_reddit
        ),
        Question(
            question = R.string.question_ibm_pc_leader,
            multipleChoices = listOf(
                R.string.choice_don_estridge,
                R.string.choice_steve_wozniak,
                R.string.choice_bill_gates,
                R.string.choice_michael_dell
            ),
            correctAnswer = R.string.choice_don_estridge
        ),
        Question(
            question = R.string.question_dell_founder,
            multipleChoices = listOf(
                R.string.choice_don_estridge,
                R.string.choice_david_packard,
                R.string.choice_charles_babbage,
                R.string.choice_michael_dell
            ),
            correctAnswer = R.string.choice_michael_dell
        ),
        Question(
            question = R.string.question_javascript_creator,
            multipleChoices = listOf(
                R.string.choice_anders_hejlsberg,
                R.string.choice_guido_van_rossum,
                R.string.choice_brendan_eich,
                R.string.choice_brendan_eich
            ),
            correctAnswer = R.string.choice_brendan_eich
        )
    )
    private val advancedQuestionsList = listOf(
        Question(
            question = R.string.question_father_information_theory,
            multipleChoices = listOf(
                R.string.choice_norbert_wiener,
                R.string.choice_claude_shannon,
                R.string.choice_john_von_neumann,
                R.string.choice_alan_turing
            ),
            correctAnswer = R.string.choice_claude_shannon
        ),
        Question(
            question = R.string.question_tcp_ip_co_creator,
            multipleChoices = listOf(
                R.string.choice_berners_lee,
                R.string.choice_vint_cerf,
                R.string.choice_bob_kahn,
                R.string.choice_marc_andreessen
            ),
            correctAnswer = R.string.choice_vint_cerf
        ),
        Question(
            question = R.string.question_free_software_foundation_founder,
            multipleChoices = listOf(
                R.string.choice_richard_stallman,
                R.string.choice_linus_torvalds,
                R.string.choice_eric_s_raymond,
                R.string.choice_ken_thompson
            ),
            correctAnswer = R.string.choice_richard_stallman
        ),
        Question(
            question = R.string.question_first_mouse_inventor,
            multipleChoices = listOf(
                R.string.choice_douglas_engelbart,
                R.string.choice_steve_jobs,
                R.string.choice_bill_english,
                R.string.choice_robert_metcalfe
            ),
            correctAnswer = R.string.choice_douglas_engelbart
        ),
        Question(
            question = R.string.question_cut_copy_paste_inventor,
            multipleChoices = listOf(
                R.string.choice_larry_tesler,
                R.string.choice_bill_gates,
                R.string.choice_steve_wozniak,
                R.string.choice_paul_allen
            ),
            correctAnswer = R.string.choice_larry_tesler
        ),
        Question(
            question = R.string.question_integrated_circuit_inventor,
            multipleChoices = listOf(
                R.string.choice_jack_kilby,
                R.string.choice_gordon_moore,
                R.string.choice_robert_noyce,
                R.string.choice_william_shockley
            ),
            correctAnswer = R.string.choice_jack_kilby
        ),
        Question(
            question = R.string.question_first_computer_mouse,
            multipleChoices = listOf(
                R.string.choice_xerox_star,
                R.string.choice_apple_lisa,
                R.string.choice_ibm_pc,
                R.string.choice_commodore_pet
            ),
            correctAnswer = R.string.choice_xerox_star
        ),
        Question(
            question = R.string.question_email_inventor,
            multipleChoices = listOf(
                R.string.choice_ray_tomlinson,
                R.string.choice_vint_cerf,
                R.string.choice_paul_buchheit,
                R.string.choice_shiva_ayyadurai
            ),
            correctAnswer = R.string.choice_ray_tomlinson
        ),
        Question(
            question = R.string.question_digital_camera_inventor,
            multipleChoices = listOf(
                R.string.choice_steven_sasson,
                R.string.choice_george_eastman,
                R.string.choice_edwin_land,
                R.string.choice_thomas_knoll
            ),
            correctAnswer = R.string.choice_steven_sasson
        ),
        Question(
            question = R.string.question_xerox_parc_scientist,
            multipleChoices = listOf(
                R.string.choice_alan_kay,
                R.string.choice_dennis_ritchie,
                R.string.choice_bjarne_stroustrup,
                R.string.choice_james_gosling
            ),
            correctAnswer = R.string.choice_alan_kay
        ),
        Question(
            question = R.string.question_basis_modern_algorithm,
            multipleChoices = listOf(
                R.string.choice_ada_lovelace,
                R.string.choice_grace_hopper,
                R.string.choice_charles_babbage,
                R.string.choice_john_backus
            ),
            correctAnswer = R.string.choice_ada_lovelace
        ),
        Question(
            question = R.string.question_harvard_mark_i_designer,
            multipleChoices = listOf(
                R.string.choice_howard_aiken,
                R.string.choice_konrad_zuse,
                R.string.choice_john_atanasoff,
                R.string.choice_clifford_berry
            ),
            correctAnswer = R.string.choice_howard_aiken
        ),
        Question(
            question = R.string.question_atari_founder,
            multipleChoices = listOf(
                R.string.choice_atari,
                R.string.choice_nintendo,
                R.string.choice_sega,
                R.string.choice_electronic_arts
            ),
            correctAnswer = R.string.choice_atari
        ),
        Question(
            question = R.string.question_microprocessor_patent,
            multipleChoices = listOf(
                R.string.choice_marcian_hoff,
                R.string.choice_federico_faggin,
                R.string.choice_robert_noyce,
                R.string.choice_geoffrey_dummer
            ),
            correctAnswer = R.string.choice_marcian_hoff
        ),
        Question(
            question = R.string.question_jobs_wozniak_first_product,
            multipleChoices = listOf(
                R.string.choice_blue_box,
                R.string.choice_hp_65,
                R.string.choice_atari_breakout,
                R.string.choice_apple_lisa
            ),
            correctAnswer = R.string.choice_blue_box
        ),
        Question(
            question = R.string.question_virtual_reality_term,
            multipleChoices = listOf(
                R.string.choice_jaron_lanier,
                R.string.choice_palmer_luckey,
                R.string.choice_mark_zuckerberg,
                R.string.choice_brendan_iribe
            ),
            correctAnswer = R.string.choice_jaron_lanier
        ),
        Question(
            question = R.string.question_turing_machine_creator,
            multipleChoices = listOf(
                R.string.choice_alan_turing,
                R.string.choice_alonzo_church,
                R.string.choice_john_von_neumann,
                R.string.choice_claude_shannon
            ),
            correctAnswer = R.string.choice_alan_turing
        ),
        Question(
            question = R.string.question_first_personal_computer,
            multipleChoices = listOf(
                R.string.choice_kenbak_1,
                R.string.choice_altair_8800,
                R.string.choice_ibm_5100,
                R.string.choice_apple_i
            ),
            correctAnswer = R.string.choice_kenbak_1
        ),
        Question(
            question = R.string.question_laser_paper_author,
            multipleChoices = listOf(
                R.string.choice_theodore_maiman,
                R.string.choice_albert_einstein,
                R.string.choice_charles_townes,
                R.string.choice_john_von_neumann
            ),
            correctAnswer = R.string.choice_theodore_maiman
        )
    )
    private val imageResourceMap = mapOf(
        R.string.choice_bill_gates to R.drawable.bill_gates,
        R.string.choice_apple to R.drawable.apple,
        R.string.choice_eniac to R.drawable.eniac,
        R.string.choice_berners_lee to R.drawable.berners_lee,
        R.string.choice_paul_allen to R.drawable.paul_allen,
        R.string.choice_online_bookstore to R.drawable.amazon_online_book_store,
        R.string.choice_python to R.drawable.python,
        R.string.choice_tesla to R.drawable.tesla,
        R.string.choice_facebook to R.drawable.facebook,
        R.string.choice_elon_musk to R.drawable.elon_musk,
        R.string.choice_oracle to R.drawable.oracle,
        R.string.choice_whatsapp to R.drawable.whatsapp,
        R.string.choice_compaq to R.drawable.compaq,
        R.string.choice_apple_macintosh to R.drawable.apple_macintosh,
        R.string.choice_google to R.drawable.google,
        R.string.choice_steve_jobs to R.drawable.steve_jobs,
        R.string.choice_playstation to R.drawable.playstation,
        R.string.choice_android to R.drawable.android,
        R.string.choice_dennis_ritchie to R.drawable.dennis_ritchie,
        R.string.choice_adobe to R.drawable.adobe,
        R.string.choice_simula to R.drawable.simula,
        R.string.choice_grace_hopper to R.drawable.grace_hopper,
        R.string.choice_linus_torvalds to R.drawable.linus_torvalds,
        R.string.choice_charles_babbage to R.drawable.charles_babbage,
        R.string.choice_sun_microsystems to R.drawable.sun_microsystems,
        R.string.choice_ken_thompson to R.drawable.ken_thompson,
        R.string.choice_univac to R.drawable.univac,
        R.string.choice_html to R.drawable.html,
        R.string.choice_alphago to R.drawable.alpha_go,
        R.string.choice_microsoft to R.drawable.microsoft,
        R.string.choice_tim_cook to R.drawable.tim_cook,
        R.string.choice_sergey_brin to R.drawable.sergey_brin,
        R.string.choice_netscape_navigator to R.drawable.netscape_navigator,
        R.string.choice_yukihiro_matsumoto to R.drawable.yukihiro_matsumoto,
        R.string.choice_reddit to R.drawable.reddit,
        R.string.choice_don_estridge to R.drawable.don_estridge,
        R.string.choice_michael_dell to R.drawable.michael_dell,
        R.string.choice_brendan_eich to R.drawable.brendan_eich,
        R.string.choice_claude_shannon to R.drawable.claude_shannon,
        R.string.choice_vint_cerf to R.drawable.vint_cerf,
        R.string.choice_richard_stallman to R.drawable.richard_stallman,
        R.string.choice_douglas_engelbart to R.drawable.douglas_engelbart,
        R.string.choice_larry_tesler to R.drawable.larry_tesler,
        R.string.choice_jack_kilby to R.drawable.jack_kilby,
        R.string.choice_xerox_star to R.drawable.xerox_star,
        R.string.choice_ray_tomlinson to R.drawable.ray_tomlinson,
        R.string.choice_steven_sasson to R.drawable.steven_sasson,
        R.string.choice_alan_kay to R.drawable.alan_kay,
        R.string.choice_ada_lovelace to R.drawable.ada_lovelace,
        R.string.choice_howard_aiken to R.drawable.howard_aiken,
        R.string.choice_atari to R.drawable.atari,
        R.string.choice_marcian_hoff to R.drawable.marcian_hoff,
        R.string.choice_blue_box to R.drawable.blue_box,
        R.string.choice_jaron_lanier to R.drawable.jaron_lanier,
        R.string.choice_alan_turing to R.drawable.alan_turing,
        R.string.choice_kenbak_1 to R.drawable.kenbak_1,
        R.string.choice_theodore_maiman to R.drawable.theodore_maiman
    )

    private var usedQuestions: MutableSet<Question> = mutableSetOf()

    fun pickQuestionsRandomly(level: Level): Question? {
        val questionsList = when (level) {
            Level.EASY -> easyQuestionsList
            Level.MEDIUM -> mediumQuestionsList
            Level.ADVANCED -> advancedQuestionsList
        }
        val questionsToRandomlyPickFrom = questionsList.filterNot { it in usedQuestions }
        if (questionsToRandomlyPickFrom.isEmpty() || usedQuestions.size >= MAX_QUESTION_NUMBER) return null

        val selectedQuestion = questionsToRandomlyPickFrom.random()
        usedQuestions.add(selectedQuestion)
        return selectedQuestion
    }

    fun pickImageOfCorrectAnswer(answer: Int): Int {
        return imageResourceMap[answer] ?: R.drawable.image_placeholder
    }

}



