package com.example.second_lab

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.button.MaterialButton
import kotlin.apply
import kotlin.let

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class PasswordChangeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_password_change, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<MaterialToolbar>(R.id.topAppBar).setNavigationOnClickListener {
            (requireActivity() as? CoreActivity)?.let { activity ->
                activity.supportFragmentManager.beginTransaction().apply {
                    hide(activity.fragmentPasswordChange)
                    show(activity.fragmentProfile)
                    commit()
                }
            }
        }

        view.findViewById<MaterialButton>(R.id.acceptButton).setOnClickListener {
            (requireActivity() as? CoreActivity)?.let { activity ->
                activity.supportFragmentManager.beginTransaction().apply {
                    hide(activity.fragmentPasswordChange)
                    show(activity.fragmentProfile)
                    commit()
                }
            }
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment PasswordChangeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PasswordChangeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}