import { FieldGroup, FieldSeparator } from "../../../components/ui/field";
import { useAuthFlow } from "../hooks/use-auth-flow";
import OAuthButton from "./oauth-button";
import EmailForm from "./email-form";
import OTPForm from "./otp-form";
import { Button } from "@/components/ui/button";
import { useLogin } from "@privy-io/react-auth";

const LoginForm = () => {
  const authFlow = useAuthFlow();
  const { login } = useLogin();
  if (authFlow.step === "email")
    return (
      <FieldGroup>
        <Button onClick={login}>Privy</Button>
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
