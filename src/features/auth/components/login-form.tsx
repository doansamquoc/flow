import { FieldGroup, FieldSeparator } from "../../../components/ui/field";
import { useAuthFlow } from "../hooks/use-auth-flow";
import OAuthButton from "./oauth-button";
import EmailForm from "./email-form";
import OTPForm from "./otp-form";

const LoginForm = () => {
  const authFlow = useAuthFlow();

  if (authFlow.step === "email")
    return (
      <FieldGroup>
        <OAuthButton provider='google' />
        <FieldSeparator>Hoặc đăng nhập với</FieldSeparator>
        <EmailForm
          loading={authFlow.isSendingCode}
          onSubmit={authFlow.submitEmail}
        />
      </FieldGroup>
    );

  return (
    <OTPForm
      email={authFlow.email}
      error={authFlow.error}
      onReset={authFlow.reset}
      onSubmit={authFlow.submitOtp}
      onResend={authFlow.resend}
    />
  );
};

export default LoginForm;
