package com.andreirookie.impl.ui.bottom

import android.os.Bundle
import android.text.InputFilter
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.andreirookie.base_cyrillic_validation.CyrillicInputFilter
import com.andreirookie.impl.R
import com.andreirookie.impl.util.EditTextWatcherFacade
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class SearchBottomDialogFragment : BottomSheetDialogFragment() {

    private lateinit var fromWhereEditText: EditText
    private lateinit var whereEditText: EditText

    private lateinit var hintItem1: ViewGroup
    private lateinit var hintItem2: ViewGroup
    private lateinit var hintItem3: ViewGroup

    private lateinit var whereEditTextButton: ImageButton

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.bottom_sheet_layout, container, false)
    }

    override fun getTheme(): Int = R.style.bottom_sheet_theme

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupSearchBlock(view)
        setupElementsRow(view)
        setupHintsBlock(view)

    }

    override fun onStart() {
        super.onStart()

        dialog?.let {
            val bottomSheet =
                it.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet) as FrameLayout
            val bottomBehavior = BottomSheetBehavior.from(bottomSheet)
            bottomBehavior.peekHeight = 744.dp()

            val layoutParams = bottomSheet.layoutParams
            layoutParams.height = WindowManager.LayoutParams.MATCH_PARENT
            bottomSheet.layoutParams = layoutParams
            bottomBehavior.state = BottomSheetBehavior.STATE_EXPANDED
        }

        arguments?.let { fromWhereEditText.setText(it.getString(FROM_WHERE_INPUT_ARG)) }

        EditTextWatcherFacade(fromWhereEditText).startListen {
            if (areFieldsFilledIn() && !fromWhereEditText.isFocused) {
                dialog?.dismiss()
                val bundle = bundleOf(
                    "fromWhereArg" to fromWhereEditText.text.toString(),
                    "whereArg" to whereEditText.text.toString()
                )
                findNavController()
                    .navigate(com.andreirookie.navigation.R.id.action_navigate_to_date_search_screen, bundle)
            }
        }
        EditTextWatcherFacade(whereEditText).startListen {
            if (areFieldsFilledIn() && !whereEditText.isFocused) {
                dialog?.dismiss()
                val bundle = bundleOf(
                    "fromWhereArg" to fromWhereEditText.text.toString(),
                    "whereArg" to whereEditText.text.toString()
                    )
                findNavController()
                    .navigate(com.andreirookie.navigation.R.id.action_navigate_to_date_search_screen, bundle)
            }
        }
    }

    private fun setupSearchBlock(view: View) {
        val searchIcon = view.findViewById<ImageView>(com.andreirookie.uikit.R.id.search_icon)
        searchIcon.visibility = View.GONE

        whereEditTextButton = view.findViewById(com.andreirookie.uikit.R.id.where_edittext_button)
        whereEditTextButton.visibility = View.VISIBLE
        whereEditTextButton.setOnClickListener {
            whereEditText.text.clear()
        }

        fromWhereEditText = view.findViewById(com.andreirookie.uikit.R.id.from_where_edittext)
        with(fromWhereEditText) {
            setCompoundDrawablesWithIntrinsicBounds(
                com.andreirookie.uikit.R.drawable.ic_plane_turned_24,
                0,
                0,
                0
            )
            hint = getString(R.string.search_screen_from_edittext_hint)
            inputType = InputType.TYPE_CLASS_TEXT
            filters = arrayOf<InputFilter>(CyrillicInputFilter())
        }

        whereEditText = view.findViewById(com.andreirookie.uikit.R.id.where_edittext)
        with(whereEditText) {
            setCompoundDrawablesWithIntrinsicBounds(
                com.andreirookie.uikit.R.drawable.ic_loupe_white_24,
                0,
                0,
                0
            )
            hint = getString(R.string.search_screen_to_edittext_hint)
            inputType = InputType.TYPE_CLASS_TEXT
            filters = arrayOf<InputFilter>(CyrillicInputFilter())
        }
    }

    private fun setupElementsRow(view: View) {
        val element1 = view.findViewById<View>(R.id.element_1)
        element1.findViewById<ImageView>(com.andreirookie.uikit.R.id.element_icon)
            .setImageResource(com.andreirookie.uikit.R.drawable.img_complex_route)
        val header1 = element1.findViewById<TextView>(com.andreirookie.uikit.R.id.element_header)
        header1.text = getString(com.andreirookie.uikit.R.string.complex_route)

        element1.setOnClickListener {
            dialog?.dismiss()
            findNavController().navigate(com.andreirookie.navigation.R.id.action_navigate_to_element_stub_frag)
        }

        val element2 = view.findViewById<View>(R.id.element_2)
        element2.findViewById<ImageView>(com.andreirookie.uikit.R.id.element_icon)
            .setImageResource(com.andreirookie.uikit.R.drawable.img_globe)
        val header2 = element2.findViewById<TextView>(com.andreirookie.uikit.R.id.element_header)
        header2.text = getString(com.andreirookie.uikit.R.string.anywhere)

        element2.setOnClickListener {
            whereEditText.setText(header2.text)
        }

        val element3 = view.findViewById<View>(R.id.element_3)
        element3.findViewById<ImageView>(com.andreirookie.uikit.R.id.element_icon)
            .setImageResource(com.andreirookie.uikit.R.drawable.img_calendar)
        val header3 = element3.findViewById<TextView>(com.andreirookie.uikit.R.id.element_header)
        header3.text = getString(com.andreirookie.uikit.R.string.weekend)

        element3.setOnClickListener {
            dialog?.dismiss()
            findNavController().navigate(com.andreirookie.navigation.R.id.action_navigate_to_element_stub_frag)
        }

        val element4 = view.findViewById<View>(R.id.element_4)
        element4.findViewById<ImageView>(com.andreirookie.uikit.R.id.element_icon)
            .setImageResource(com.andreirookie.uikit.R.drawable.img_flame)
        val header4 = element4.findViewById<TextView>(com.andreirookie.uikit.R.id.element_header)
        header4.text = getString(com.andreirookie.uikit.R.string.hot_tickets)

        element4.setOnClickListener {
            dialog?.dismiss()
            findNavController().navigate(com.andreirookie.navigation.R.id.action_navigate_to_element_stub_frag)
        }
    }

    private fun setupHintsBlock(view: View) {

        hintItem1 = view.findViewById(R.id.hint_1)
        hintItem1.findViewById<ImageView>(R.id.hint_image)
            .setImageResource(com.andreirookie.uikit.R.drawable.img_hint_stub_1)
        val hint1TownTextView = hintItem1.findViewById<TextView>(R.id.hint_town_text_view)
        hint1TownTextView.text = "Стамбул"

        hintItem1.setOnClickListener {
            whereEditText.setText(hint1TownTextView.text)
        }

        hintItem2 = view.findViewById(R.id.hint_2)
        hintItem2.findViewById<ImageView>(R.id.hint_image)
            .setImageResource(com.andreirookie.uikit.R.drawable.img_hint_stub_2)
        val hint2TownTextView = hintItem2.findViewById<TextView>(R.id.hint_town_text_view)
        hint2TownTextView.text = "Сочи"

        hintItem2.setOnClickListener {
            whereEditText.setText(hint2TownTextView.text)
        }

        hintItem3 = view.findViewById(R.id.hint_3)
        hintItem3.findViewById<ImageView>(R.id.hint_image)
            .setImageResource(com.andreirookie.uikit.R.drawable.img_hint_stub_3)
        val hint3TownTextView = hintItem3.findViewById<TextView>(R.id.hint_town_text_view)
        hint3TownTextView.text = "Пхукет"

        hintItem3.setOnClickListener {
            whereEditText.setText(hint3TownTextView.text)
        }
    }

    fun putInputArg(arg: String) {
        arguments = bundleOf(Pair(FROM_WHERE_INPUT_ARG, arg))
    }

    private fun areFieldsFilledIn(): Boolean {
        return fromWhereEditText.text.isNotEmpty() &&
                whereEditText.text.isNotEmpty()
    }

    private fun Int.dp(): Int =
        (this * requireContext().resources.displayMetrics.density).toInt()

    companion object {
        const val TAG = "SearchBottomDialogFragment"
        private const val FROM_WHERE_INPUT_ARG = "arg_input"
    }
}